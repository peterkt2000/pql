import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import de.java2html.converter.JavaSource2HTMLConverter;
import de.java2html.javasource.JavaSource;
import de.java2html.javasource.JavaSourceParser;
import de.java2html.options.JavaSourceConversionOptions;
import de.java2html.util.IllegalConfigurationException;
import mil.darpa.immortals.core.das.pql.IPQLProgram;
import mil.darpa.immortals.core.das.pql.PQLExecutionResult;
import mil.darpa.immortals.core.das.pql.PQLProgramGenerator;
import mil.darpa.immortals.core.das.pql.PQLProgramResult;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import org.antlr.v4.gui.TreeViewer;
import org.jmeld.settings.FolderSettings;
import org.jmeld.settings.JMeldSettings;
import org.jmeld.ui.JMeldPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PQLEditor {

	private JFrame frmPQLEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PQLEditor window = new PQLEditor();
					window.frmPQLEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	if (currentFileTreePath != null) {
	        		PQLEditor.storeStringPreference(LAST_DIRECTORY_EXPLORER, currentFileTreePath);
	        	}
	        }
	    }, "Shutdown-thread"));
	}

	/**
	 * Create the application.
	 */
	public PQLEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPQLEditor = new JFrame();
		frmPQLEditor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (editingPQLSourceFile && pqlProgramIsDirty && currentPQLSourceFile != null) {
				    int saveResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
				            "Do you want to save the existing PQL file?",
				            "Confirm", JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE);
				    if (saveResponse == JOptionPane.YES_OPTION) {
				    	savePQLProgram();
				    }
				}
			}
		});
		frmPQLEditor.setTitle("PQL Editor");
		frmPQLEditor.setBounds(100, 100, 1139, 843);
		frmPQLEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmPQLEditor.getContentPane().setLayout(springLayout);
		
		leftTopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		leftTopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel fileExplorer = new JPanel();
		

		leftTopTabbedPane.addTab("File Explorer", null, fileExplorer, null);
		fileExplorer.setLayout(new BorderLayout(0, 0));
		
		fileTree = new JTree(new DefaultMutableTreeNode(FILE_TREE_ROOT_USER_OBJECT));
		fileTree.setScrollsOnExpand(true);
		fileTree.addTreeWillExpandListener(new TreeWillExpandListener() {
			public void treeWillCollapse(TreeExpansionEvent event) {
			}
			public void treeWillExpand(TreeExpansionEvent event) {
				DefaultMutableTreeNode expandingNode = ((DefaultMutableTreeNode) event.getPath().getLastPathComponent());
				if (expandingNode.getChildCount() == 1) {
					DefaultMutableTreeNode expandingNodeChild = (DefaultMutableTreeNode) expandingNode.getChildAt(0);
					if (((PathTreeNode) expandingNodeChild.getUserObject()).getTag() == TREE_PLACEHOLDER) {
						expandingNodeChild.removeFromParent();
						TreePath treePath = event.getPath();
						StringBuilder directoryPath = new StringBuilder();
						directoryPath.append(treePath.getPathComponent(1));
						for (int x = 2; x < treePath.getPathCount(); x++) {
							directoryPath.append(FILE_SEPARATOR + treePath.getPathComponent(x));
						}
						addFileTreeNodes(expandingNode, Paths.get(directoryPath.toString()));
						event.getPath().toString();
					}
				}

				currentFileTreePath = "";
				for (int x = 0; x < event.getPath().getPathCount(); x++) {
					currentFileTreePath += event.getPath().getPathComponent(x) + ",";
				}
				currentFileTreePath = currentFileTreePath.substring(0, currentFileTreePath.length()-1);
			}
		});

		fileTree.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                       fileTree.getLastSelectedPathComponent();
	                if (node == null) return;
	                
	                TreePath treePath = fileTree.getSelectionPath();
	                if (treePath.getPathCount() > 1) {
						StringBuilder directoryPath = new StringBuilder();
						directoryPath.append(treePath.getPathComponent(1));
						for (int x = 2; x < treePath.getPathCount(); x++) {
							directoryPath.append(FILE_SEPARATOR + treePath.getPathComponent(x));
						}
						if (treePath.getLastPathComponent().toString().endsWith("." + PQL_FILE_EXTENSION)) {
							loadPQLProgram(directoryPath.toString());
						}
	                }
	            }
	        }
	    });
		
		JScrollPane treeView = new JScrollPane(fileTree);
		fileExplorer.add(treeView, BorderLayout.CENTER);
		
		leftBottomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		leftBottomTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		rightTopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightTopTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		JPanel pnlPQLProgram = new JPanel();

		rightTopTabbedPane.addTab("PQL Source", null, pnlPQLProgram, null);
		pnlPQLProgram.setLayout(new BorderLayout(0, 0));
		
		JScrollPane baselineCodeScroll = new JScrollPane();
		baselineCodeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnlPQLProgram.add(baselineCodeScroll);
		
		textAreaPQLProgram = new JTextArea();
		textAreaPQLProgram.setEnabled(false);
		textAreaPQLProgram.setFont(new Font("Dialog", Font.PLAIN, 15));
		textAreaPQLProgram.setTabSize(2);
		textAreaPQLProgram.getDocument().addDocumentListener(new ListenForAnyUpdate());
		baselineCodeScroll.setViewportView(textAreaPQLProgram);

		JPanel pnlGeneratedProgram = new JPanel();
		rightTopTabbedPane.addTab("Generated Program", null, pnlGeneratedProgram, null);
		pnlGeneratedProgram.setLayout(new BorderLayout(0, 0));
		
		JScrollPane generatedProgramScroll = new JScrollPane();
		generatedProgramScroll.setPreferredSize(new Dimension(100, 100));
		pnlGeneratedProgram.add(generatedProgramScroll);
		
		StyledEditorKit kit = new HTMLEditorKit();
		HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
		doc.setPreservesUnknownTags(false);

		textPaneGeneratedProgram = new JTextPane();
		textPaneGeneratedProgram.setEditable(false);
		textPaneGeneratedProgram.setEditorKit(kit);
		textPaneGeneratedProgram.setStyledDocument((StyledDocument) doc);
		textPaneGeneratedProgram.setContentType("");

		generatedProgramScroll.setViewportView(textPaneGeneratedProgram);

		//Create panel to show PQL parse tree
		pnlPQLParseTreeTab = new JPanel();
		rightTopTabbedPane.addTab("PQL Parse Tree", null, pnlPQLParseTreeTab, null);
		pnlPQLParseTreeTab.setLayout(new BorderLayout(0, 0));

		pqlParseTreeScroll = new JScrollPane();
		pqlParseTreeScroll.setPreferredSize(new Dimension(100, 100));
		pnlPQLParseTreeTab.add(pqlParseTreeScroll);
		
		pnlPQLParseTreeTab.setBackground(Color.WHITE);
		
		JPanel pnlExaminedFiles = new JPanel();
		leftBottomTabbedPane.addTab("Examined Files", null, pnlExaminedFiles, null);
		pnlExaminedFiles.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollExaminedFiles = new JScrollPane();
		pnlExaminedFiles.add(scrollExaminedFiles, BorderLayout.CENTER);
		
		modelExaminedFiles = new DefaultListModel<String>();
		listExaminedFiles = new JList<>(modelExaminedFiles);
		listExaminedFiles.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (pqlResult != null && !listExaminedFiles.isSelectionEmpty()) {
					showOriginalSource(modelExaminedFiles.get(listExaminedFiles.getSelectedIndex()));
				}
			}
		});
		scrollExaminedFiles.setViewportView(listExaminedFiles);

		JPanel pnlModifiedFiles = new JPanel();
		leftBottomTabbedPane.addTab("Modified Files", null, pnlModifiedFiles, null);
		pnlModifiedFiles.setLayout(new BorderLayout(0,0));
		
		JScrollPane scrollModifiedFiles = new JScrollPane();
		pnlModifiedFiles.add(scrollModifiedFiles, BorderLayout.CENTER);
		
		modelModifiedFiles = new DefaultListModel<String>();
		listModifiedFiles = new JList<>(modelModifiedFiles);
		listModifiedFiles.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (pqlResult != null && !listModifiedFiles.isSelectionEmpty()) {
					//showModifiedSource(modelModifiedFiles.get(listModifiedFiles.getSelectedIndex()));
					String modifiedFileString = modelModifiedFiles.get(listModifiedFiles.getSelectedIndex());
					Path modifiedFile = Paths.get(modifiedFileString); 
					Path targetFile = pqlResult.getModifiedFiles().get(modifiedFile);
					showDiff(modifiedFile, targetFile);
				}
			}
		});
		scrollModifiedFiles.setViewportView(listModifiedFiles);
				
		JSplitPane mainLeftSplitPane = new JSplitPane();
		mainLeftSplitPane.setBorder(null);
		mainLeftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		
		JSplitPane mainRightSplitPane = new JSplitPane();
		
		mainRightSplitPane.setBorder(null);
		mainRightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		mainLeftSplitPane.setTopComponent(leftTopTabbedPane);
		mainLeftSplitPane.setBottomComponent(leftBottomTabbedPane);
		
		mainRightSplitPane.setTopComponent(rightTopTabbedPane);

		JSplitPane mainSplitPane = new JSplitPane();
		springLayout.putConstraint(SpringLayout.WEST, mainSplitPane, 10, SpringLayout.WEST, frmPQLEditor.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, mainSplitPane, -5, SpringLayout.SOUTH, frmPQLEditor.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mainSplitPane, -12, SpringLayout.EAST, frmPQLEditor.getContentPane());
		
		mainSplitPane.setBorder(null);
		mainSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setTopComponent(mainLeftSplitPane);
		mainSplitPane.setBottomComponent(mainRightSplitPane);

		rightBottomTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightBottomTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel panelConsole = new JPanel();
		rightBottomTabbedPane.addTab("Console", null, panelConsole, null);
		panelConsole.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneConsole = new JScrollPane();
		panelConsole.add(scrollPaneConsole, BorderLayout.CENTER);

		mainRightSplitPane.setBottomComponent(rightBottomTabbedPane);

		textAreaConsole = new JTextArea();
		textAreaConsole.setEditable(false);
		scrollPaneConsole.setViewportView(textAreaConsole);
		
		JPanel panelOriginalSource = new JPanel();
		rightTopTabbedPane.addTab("Java Source", null, panelOriginalSource, null);
		panelOriginalSource.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneOriginalSource = new JScrollPane();
		panelOriginalSource.add(scrollPaneOriginalSource, BorderLayout.CENTER);
		
		StyledEditorKit kit2 = new HTMLEditorKit();
		HTMLDocument doc2 = (HTMLDocument) kit2.createDefaultDocument();
		doc2.setPreservesUnknownTags(false);

		textPaneOriginalSource = new JTextPane();
		textPaneOriginalSource.setEditable(false);
		textPaneOriginalSource.setEditorKit(kit2);
		textPaneOriginalSource.setStyledDocument((StyledDocument) doc2);
		textPaneOriginalSource.setContentType("text/html");

		scrollPaneOriginalSource.setViewportView(textPaneOriginalSource);
		
		//Add diff component
        JMeldSettings settings = JMeldSettings.getInstance();
        settings.getEditor().setShowLineNumbers(true);
        settings.getFolder().setView(FolderSettings.FolderView.fileView);
        settings.setDrawCurves(true);
        settings.setCurveType(1);
        //settings.getEditor().setRightsideReadonly(true);
        //settings.getEditor().setLeftsideReadonly(true);

		JPanel diffPanel = new JPanel();
		rightTopTabbedPane.addTab("Code Diff", null, diffPanel, null);
		diffPanel.setLayout(new BorderLayout(0, 0));
		
		scrollPaneDiff = new JScrollPane();
		diffPanel.add(scrollPaneDiff, BorderLayout.CENTER);
		
        jmeldPanel = new JMeldPanel();
        //jmeldPanel.SHOW_FILE_TOOLBAR_OPTION.disable();
        //jmeldPanel.SHOW_FILE_STATUSBAR_OPTION.disable();
        //jmeldPanel.SHOW_STATUSBAR_OPTION.disable();
        //jmeldPanel.SHOW_TOOLBAR_OPTION.disable();
        //jmeldPanel.SHOW_TABBEDPANE_OPTION.disable();

		scrollPaneDiff.setViewportView(jmeldPanel);
		rightTopTabbedPane.setEnabledAt(4, false);
		
		mainRightSplitPane.setDividerLocation(500);
		mainLeftSplitPane.setDividerLocation(500);
		
		frmPQLEditor.getContentPane().add(mainSplitPane);

		JPanel pnlBasicConfiguration = new JPanel();
		rightBottomTabbedPane.addTab("Basic Configuration", null, pnlBasicConfiguration, null);
		SpringLayout sl_BasicConfiguration = new SpringLayout();
		pnlBasicConfiguration.setLayout(sl_BasicConfiguration);
		
		JLabel lblSourceCodeFolder = new JLabel("Source Code To Analyze:");
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, lblSourceCodeFolder, 40, SpringLayout.NORTH, pnlBasicConfiguration);
		sl_BasicConfiguration.putConstraint(SpringLayout.WEST, lblSourceCodeFolder, 10, SpringLayout.WEST, pnlBasicConfiguration);
		pnlBasicConfiguration.add(lblSourceCodeFolder);
		
		textSourceCodeFolder = new JTextField();
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, textSourceCodeFolder, 0, SpringLayout.NORTH, lblSourceCodeFolder);
		sl_BasicConfiguration.putConstraint(SpringLayout.WEST, textSourceCodeFolder, 6, SpringLayout.EAST, lblSourceCodeFolder);
		textSourceCodeFolder.setText("");
		textSourceCodeFolder.setColumns(10);
		textSourceCodeFolder.getDocument().addDocumentListener(new ListenForAnyUpdate());
		
		pnlBasicConfiguration.add(textSourceCodeFolder);
		
		JButton btnFindSource = new JButton("Find");
		btnFindSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFolderLocation(textSourceCodeFolder);
			}
		});
		sl_BasicConfiguration.putConstraint(SpringLayout.EAST, textSourceCodeFolder, -10, SpringLayout.WEST, btnFindSource);
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, btnFindSource, 0, SpringLayout.NORTH, lblSourceCodeFolder);
		sl_BasicConfiguration.putConstraint(SpringLayout.EAST, btnFindSource, -10, SpringLayout.EAST, pnlBasicConfiguration);
		pnlBasicConfiguration.add(btnFindSource);
		
		//here
		JLabel lblTargetCodeFolder = new JLabel("Target For Modifications:");
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, lblTargetCodeFolder, 80, SpringLayout.NORTH, pnlBasicConfiguration);
		sl_BasicConfiguration.putConstraint(SpringLayout.WEST, lblTargetCodeFolder, 10, SpringLayout.WEST, pnlBasicConfiguration);
		pnlBasicConfiguration.add(lblTargetCodeFolder);
		
		textTargetCodeFolder = new JTextField();
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, textTargetCodeFolder, 0, SpringLayout.NORTH, lblTargetCodeFolder);
		sl_BasicConfiguration.putConstraint(SpringLayout.WEST, textTargetCodeFolder, 0, SpringLayout.WEST, textSourceCodeFolder);
		textTargetCodeFolder.setText("");
		textTargetCodeFolder.setColumns(10);
		textTargetCodeFolder.getDocument().addDocumentListener(new ListenForAnyUpdate());
		pnlBasicConfiguration.add(textTargetCodeFolder);
		
		JButton btnFindTarget = new JButton("Find");
		btnFindTarget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFolderLocation(textTargetCodeFolder);
			}
		});
		sl_BasicConfiguration.putConstraint(SpringLayout.EAST, textTargetCodeFolder, -10, SpringLayout.WEST, btnFindTarget);
		sl_BasicConfiguration.putConstraint(SpringLayout.NORTH, btnFindTarget, 0, SpringLayout.NORTH, lblTargetCodeFolder);
		sl_BasicConfiguration.putConstraint(SpringLayout.EAST, btnFindTarget, -10, SpringLayout.EAST, pnlBasicConfiguration);
		pnlBasicConfiguration.add(btnFindTarget);
		//here
		
		JPanel pnlSourceTypeSolverConfiguration = new JPanel();
		rightBottomTabbedPane.addTab("Type Solver Source Folders", null, pnlSourceTypeSolverConfiguration, null);
		SpringLayout sl_SourceTypeSolver = new SpringLayout();
		pnlSourceTypeSolverConfiguration.setLayout(sl_SourceTypeSolver);
		
		JLabel lblTypeSolverSourcePath = new JLabel("Source Code Paths for Resolving Types:");
		sl_SourceTypeSolver.putConstraint(SpringLayout.NORTH, lblTypeSolverSourcePath, 10, SpringLayout.NORTH, pnlSourceTypeSolverConfiguration);
		sl_SourceTypeSolver.putConstraint(SpringLayout.WEST, lblTypeSolverSourcePath, 10, SpringLayout.WEST, pnlSourceTypeSolverConfiguration);
		pnlSourceTypeSolverConfiguration.add(lblTypeSolverSourcePath);

		String helpLabelSource = "Choose the Java source folder that contains the class definitions PQL will need to resolve. " +
				"You should add all the source projects your target code depends on." +
				"\n\nExample: /JavaProject/SubFolderx/src";
		JTextArea lblTypeSolverSourcePathHelp = new JTextArea(helpLabelSource);
		lblTypeSolverSourcePathHelp.setEditable(false);
		lblTypeSolverSourcePathHelp.setFocusable(false);
		lblTypeSolverSourcePathHelp.setOpaque(false);
		lblTypeSolverSourcePathHelp.setLineWrap(true);
		lblTypeSolverSourcePathHelp.setWrapStyleWord(true);
		sl_SourceTypeSolver.putConstraint(SpringLayout.NORTH, lblTypeSolverSourcePathHelp, 10, SpringLayout.SOUTH, lblTypeSolverSourcePath);
		sl_SourceTypeSolver.putConstraint(SpringLayout.WEST, lblTypeSolverSourcePathHelp, 10, SpringLayout.WEST, pnlSourceTypeSolverConfiguration);
		sl_SourceTypeSolver.putConstraint(SpringLayout.EAST, lblTypeSolverSourcePathHelp, 0, SpringLayout.EAST, lblTypeSolverSourcePath);
		pnlSourceTypeSolverConfiguration.add(lblTypeSolverSourcePathHelp);
		
		JScrollPane scrollPaneSourceTypeSolverPaths = new JScrollPane();
		scrollPaneSourceTypeSolverPaths.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sl_SourceTypeSolver.putConstraint(SpringLayout.NORTH, scrollPaneSourceTypeSolverPaths, 10, SpringLayout.NORTH, pnlSourceTypeSolverConfiguration);
		sl_SourceTypeSolver.putConstraint(SpringLayout.WEST, scrollPaneSourceTypeSolverPaths, 10, SpringLayout.EAST, lblTypeSolverSourcePath);
		sl_SourceTypeSolver.putConstraint(SpringLayout.SOUTH, scrollPaneSourceTypeSolverPaths, -10, SpringLayout.SOUTH, pnlSourceTypeSolverConfiguration);
		pnlSourceTypeSolverConfiguration.add(scrollPaneSourceTypeSolverPaths);
		
		textAreaSourceTypeSolverPaths = new JTextArea();
		textAreaSourceTypeSolverPaths.getDocument().addDocumentListener(new ListenForAnyUpdate());
		scrollPaneSourceTypeSolverPaths.setViewportView(textAreaSourceTypeSolverPaths);
		
		JButton bnFindSourceTypeSolverPath = new JButton("Find");
		bnFindSourceTypeSolverPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFolderLocation(textAreaSourceTypeSolverPaths);
			}
		});
		sl_SourceTypeSolver.putConstraint(SpringLayout.NORTH, bnFindSourceTypeSolverPath, 10, SpringLayout.NORTH, pnlSourceTypeSolverConfiguration);
		sl_SourceTypeSolver.putConstraint(SpringLayout.EAST, scrollPaneSourceTypeSolverPaths, -10, SpringLayout.WEST, bnFindSourceTypeSolverPath);
		sl_SourceTypeSolver.putConstraint(SpringLayout.EAST, bnFindSourceTypeSolverPath, -10, SpringLayout.EAST, pnlSourceTypeSolverConfiguration);
		pnlSourceTypeSolverConfiguration.add(bnFindSourceTypeSolverPath);
		
		JPanel pnlJarTypeSolverConfiguration = new JPanel();
		rightBottomTabbedPane.addTab("Type Solver JAR Files", null, pnlJarTypeSolverConfiguration, null);
		SpringLayout sl_JARTypeSolver = new SpringLayout();
		pnlJarTypeSolverConfiguration.setLayout(sl_JARTypeSolver);
		
		JLabel lblTypeSolverJARPath = new JLabel("JAR Files for Resolving Types:");
		sl_JARTypeSolver.putConstraint(SpringLayout.NORTH, lblTypeSolverJARPath, 10, SpringLayout.NORTH, pnlJarTypeSolverConfiguration);
		sl_JARTypeSolver.putConstraint(SpringLayout.WEST, lblTypeSolverJARPath, 10, SpringLayout.WEST, pnlJarTypeSolverConfiguration);
		pnlJarTypeSolverConfiguration.add(lblTypeSolverJARPath);

		String helpLabelJAR = "Choose the Java JAR file locations that contain the class definitions PQL will need to resolve. " +
				"You should add all the references your target code depends on." +
				"\n\nExample: /ThirdPartyLibrary/lib/utility.jar";
		JTextArea lblTypeSolverJARPathHelp = new JTextArea(helpLabelJAR);
		lblTypeSolverJARPathHelp.setEditable(false);
		lblTypeSolverJARPathHelp.setFocusable(false);
		lblTypeSolverJARPathHelp.setOpaque(false);
		lblTypeSolverJARPathHelp.setLineWrap(true);
		lblTypeSolverJARPathHelp.setWrapStyleWord(true);

		sl_JARTypeSolver.putConstraint(SpringLayout.NORTH, lblTypeSolverJARPathHelp, 10, SpringLayout.SOUTH, lblTypeSolverJARPath);
		sl_JARTypeSolver.putConstraint(SpringLayout.WEST, lblTypeSolverJARPathHelp, 10, SpringLayout.WEST, pnlJarTypeSolverConfiguration);
		sl_JARTypeSolver.putConstraint(SpringLayout.EAST, lblTypeSolverJARPathHelp, 0, SpringLayout.EAST, lblTypeSolverJARPath);
		pnlJarTypeSolverConfiguration.add(lblTypeSolverJARPathHelp);
		
		JScrollPane scrollPaneJARTypeSolverFiles = new JScrollPane();
		scrollPaneJARTypeSolverFiles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sl_JARTypeSolver.putConstraint(SpringLayout.NORTH, scrollPaneJARTypeSolverFiles, 10, SpringLayout.NORTH, pnlJarTypeSolverConfiguration);
		sl_JARTypeSolver.putConstraint(SpringLayout.WEST, scrollPaneJARTypeSolverFiles, 10, SpringLayout.EAST, lblTypeSolverJARPath);
		sl_JARTypeSolver.putConstraint(SpringLayout.SOUTH, scrollPaneJARTypeSolverFiles, -10, SpringLayout.SOUTH, pnlJarTypeSolverConfiguration);
		pnlJarTypeSolverConfiguration.add(scrollPaneJARTypeSolverFiles);
		
		JButton btnFindJARSolverFile = new JButton("Find");
		btnFindJARSolverFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFileLocation(textAreaJARTypeSolverFiles);
			}
		});
		sl_JARTypeSolver.putConstraint(SpringLayout.EAST, scrollPaneJARTypeSolverFiles, -10, SpringLayout.WEST, btnFindJARSolverFile);
		
		textAreaJARTypeSolverFiles = new JTextArea();
		textAreaJARTypeSolverFiles.getDocument().addDocumentListener(new ListenForAnyUpdate());
		scrollPaneJARTypeSolverFiles.setViewportView(textAreaJARTypeSolverFiles);
		sl_JARTypeSolver.putConstraint(SpringLayout.NORTH, btnFindJARSolverFile, 10, SpringLayout.NORTH, pnlJarTypeSolverConfiguration);
		sl_JARTypeSolver.putConstraint(SpringLayout.EAST, btnFindJARSolverFile, -10, SpringLayout.EAST, pnlJarTypeSolverConfiguration);
		pnlJarTypeSolverConfiguration.add(btnFindJARSolverFile);
		mainSplitPane.setDividerLocation(250);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setOpaque(false);
		springLayout.putConstraint(SpringLayout.NORTH, toolBar, 0, SpringLayout.NORTH, frmPQLEditor.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, toolBar, 0, SpringLayout.WEST, mainSplitPane);
		frmPQLEditor.getContentPane().add(toolBar);
		
		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPQLProgram(null);
			}
		});
		btnOpen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnOpen.setToolTipText("Open...");
		btnOpen.setIcon(new ImageIcon(PQLEditor.class.getResource("document_open_24.png")));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePQLProgram();
			}
		});
		btnSave.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSave.setToolTipText("Save");
		btnSave.setIcon(new ImageIcon(PQLEditor.class.getResource("document_save_24.png")));
		toolBar.add(btnSave);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPQLProgram();
			}
		});
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setToolTipText("New...");
		btnNewButton.setIcon(new ImageIcon(PQLEditor.class.getResource("document_new_24.png")));
		toolBar.add(btnNewButton);
		
		toolBar.addSeparator();
		
		JButton btnCompile = new JButton("");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generatePQLProgram(false);
			}
		});
		btnCompile.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCompile.setToolTipText("Compile");
		btnCompile.setIcon(new ImageIcon(PQLEditor.class.getResource("script_lightning_24.png")));
		toolBar.add(btnCompile);
		
		JButton btnRun = new JButton("");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runPQLProgram();
			}
		});
		btnRun.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnRun.setToolTipText("Compile & Run");
		btnRun.setIcon(new ImageIcon(PQLEditor.class.getResource("script_go_24.png")));
		toolBar.add(btnRun);
				
		JMenuBar menuBar = new JMenuBar();
		frmPQLEditor.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoadPqlProgram = new JMenuItem("Open...");
		mntmLoadPqlProgram.setIcon(new ImageIcon(PQLEditor.class.getResource("document_open_16.png")));
		
		mntmLoadPqlProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPQLProgram(null);
			}
		});
		mnFile.add(mntmLoadPqlProgram);

		JMenuItem mntmSavePqlProgram = new JMenuItem("Save");
		mntmSavePqlProgram.setIcon(new ImageIcon(PQLEditor.class.getResource("document_save_16.png")));
		
		mntmSavePqlProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePQLProgram();
			}
		});
		mnFile.add(mntmSavePqlProgram);
		
		JMenuItem mntmNewPqlProgram = new JMenuItem("New...");
		mntmNewPqlProgram.setIcon(new ImageIcon(PQLEditor.class.getResource("document_new_16.png")));
		mntmNewPqlProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPQLProgram();
			}
		});
		mnFile.add(mntmNewPqlProgram);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePQLProgram();
			}
		});
		
		mnFile.addSeparator();
		
		mnFile.add(mntmClose);
		
		mnFile.addSeparator();

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmClearConsole = new JMenuItem("Clear Console");
		mntmClearConsole.setIcon(new ImageIcon(PQLEditor.class.getResource("package_purge_16.png")));
		mntmClearConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearConsoleMessages();
			}
		});
		mnTools.add(mntmClearConsole);
		
		JMenu mnRun = new JMenu("Run");
		menuBar.add(mnRun);
		
		mntmParsePql = new JMenuItem("Compile");
		mntmParsePql.setIcon(new ImageIcon(PQLEditor.class.getResource("script_lightning_16.png")));
		
		mntmParsePql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generatePQLProgram(false);
			}
		});
		mnRun.add(mntmParsePql);
		
		mntmRunPql = new JMenuItem("Compile & Run");
		mntmRunPql.setIcon(new ImageIcon(PQLEditor.class.getResource("script_go_16.png")));
		
		mntmRunPql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runPQLProgram();
			}
		});
		initializeFileTree();
		mnRun.add(mntmRunPql);
		
		springLayout.putConstraint(SpringLayout.NORTH, mainSplitPane, 10, SpringLayout.SOUTH, toolBar);
		
		JButton btnClearConsole = new JButton("");
		btnClearConsole.setToolTipText("Clear Console");
		btnClearConsole.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		toolBar.addSeparator();
		toolBar.add(btnClearConsole);
		btnClearConsole.setIcon(new ImageIcon(PQLEditor.class.getResource("package_purge_24.png")));
		
		btnClearConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearConsoleMessages();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnClearConsole, 0, SpringLayout.NORTH, toolBar);
		springLayout.putConstraint(SpringLayout.WEST, btnClearConsole, 6, SpringLayout.EAST, toolBar);
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem mntmCopyFile = new JMenuItem("Copy ...");
		mntmCopyFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyFile();
			}
		});

		JMenuItem mntmRenameFile = new JMenuItem("Move/Rename ...");
		mntmRenameFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renameFile();
			}
		});
		
		JMenuItem mntmDeleteFile = new JMenuItem("Delete ...");
		mntmDeleteFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFile();
			}
		});
		
		popupMenu.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if (fileTree.getSelectionCount() > 0) {
					mntmRenameFile.setEnabled(true);
					mntmDeleteFile.setEnabled(true);
					mntmCopyFile.setEnabled(true);
				} else {
					mntmRenameFile.setEnabled(false);
					mntmDeleteFile.setEnabled(false);
					mntmCopyFile.setEnabled(false);
				}
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}			
		});
		addPopup(fileTree, popupMenu);
		
		popupMenu.add(mntmRenameFile);
		popupMenu.add(mntmDeleteFile);
		popupMenu.add(mntmCopyFile);
	}
	
	private boolean deleteFile() {
		
		boolean result = false;
		
		TreePath path = fileTree.getSelectionPath();
		
		String pathAsString = "";
		for (int x = 1; x < path.getPathCount(); x++) {
			pathAsString = pathAsString.concat(path.getPathComponent(x).toString() + "/");
		}
		pathAsString = pathAsString.substring(0, pathAsString.length()-1);
		
		Path pathToDelete = Paths.get(pathAsString);

		if (currentPQLSourceFile != null && pathToDelete.equals(Paths.get(currentPQLSourceFile))) {
			showInformationMessage(null, "You cannot delete a PQL file that is open. Close the file first using the File menu.");
		} else {
			if (pathToDelete.toFile().isFile()) {
			    int saveResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
			            "Do you want to delete this file?\n" + pathToDelete.toString(),
			            "Confirm", JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE);
			    if (saveResponse == JOptionPane.YES_OPTION) {
					pathToDelete.toFile().delete();
					rebuildFileTree();
					result = true;
			    }
			} else {
				//Cannot delete directories in PQL
				showInformationMessage(null, "You may not delete directories using this tool.");
			}
		}
		
		return result;
	}
	
	private boolean renameFile() {

		boolean result = false;
		
		TreePath path = fileTree.getSelectionPath();
		
		String pathAsString = "";
		for (int x = 1; x < path.getPathCount(); x++) {
			pathAsString = pathAsString.concat(path.getPathComponent(x).toString() + "/");
		}
		pathAsString = pathAsString.substring(0, pathAsString.length()-1);
		
		Path pathToRename = Paths.get(pathAsString);
		
		if (currentPQLSourceFile != null && pathToRename.equals(Paths.get(currentPQLSourceFile))) {
			showInformationMessage(null, "You cannot rename a PQL file that is open. Close the file first using the File menu.");
		} else {
			if (pathToRename.toFile().isFile()) {
				String newName = getUserTextInput(null, "Type the new file name", pathToRename.toString());
				if (newName != null && newName.length() > 0) {
					Path dest = Paths.get(newName);
			    	try {
						Files.move(pathToRename, dest);
					} catch (IOException e) {
						showInformationMessage(null, "Could not move/rename file: " + e.getMessage());
					}
					rebuildFileTree();
					result = true;
			    }
			} else {
				//Cannot rename directories in PQL
				showInformationMessage(null, "You may not rename directories using this tool.");
			}
		}
		
		return result;

	}

	private boolean copyFile() {

		boolean result = false;
		
		TreePath path = fileTree.getSelectionPath();
		
		String pathAsString = "";
		for (int x = 1; x < path.getPathCount(); x++) {
			pathAsString = pathAsString.concat(path.getPathComponent(x).toString() + "/");
		}
		pathAsString = pathAsString.substring(0, pathAsString.length()-1);
		
		Path pathToCopy = Paths.get(pathAsString);

		if (currentPQLSourceFile != null && pathToCopy.equals(Paths.get(currentPQLSourceFile))) {
			showInformationMessage(null, "You cannot copy a PQL file that is open. Close the file first using the File menu.");
		} else {
			if (pathToCopy.toFile().isFile()) {
				String newName = getUserTextInput(null, "Type the new file name", pathToCopy.toString());
				if (newName != null && newName.length() > 0) {
					Path dest = Paths.get(newName);
			    	try {
						Files.copy(pathToCopy, dest);
					} catch (IOException e) {
						showInformationMessage(null, "Could not copy file: " + e.getMessage());
					}
					rebuildFileTree();
					result = true;
			    }
			} else {
				//Cannot copy directories in PQL
				showInformationMessage(null, "You may not copy directories using this tool.");
			}
		}
		
		return result;

	}

	private String getUserTextInput(Container parent, String prompt, String initialValue) {
		
		if (parent == null) {
			parent = getMainFrame();
		}
		
		return (String) JOptionPane.showInputDialog(parent, prompt, 
				"Input Required", JOptionPane.PLAIN_MESSAGE, null, null, initialValue);
	}
	
	private void showInformationMessage(Container parent, String message) {

		if (parent == null) {
			parent = getMainFrame();
		}
		
		JOptionPane.showMessageDialog(parent, message, "Alert", JOptionPane.INFORMATION_MESSAGE, null);
	}

	private JFrame getMainFrame() {
		return frmPQLEditor;
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void loadPQLProgram(String filePath) {
		
		if (editingPQLSourceFile && pqlProgramIsDirty && currentPQLSourceFile != null) {
		    int saveResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
		            "Do you want to save the existing PQL file?",
		            "Confirm", JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE);
		    if (saveResponse == JOptionPane.YES_OPTION) {
		    	savePQLProgram();
		    }
		}
		
		resetPQLEditor();
		
		File file = null;
		
		if (filePath == null || filePath.trim().length() == 0) {
			file = getUserChosenPQLFile();
		} else {
			file = Paths.get(filePath).toFile();
		}
		
		if (file != null) {
			try (BufferedReader bReader = Files.newBufferedReader(file.toPath());
					JsonReader reader = Json.createReader(bReader);) {
		        JsonObject jsonObject = reader.readObject();
		        if (jsonObject != null) {
		        	textSourceCodeFolder.setText(jsonObject.getString("source-code-folder"));
		        	textTargetCodeFolder.setText(jsonObject.getString("target-code-folder"));
		        	textAreaSourceTypeSolverPaths.setText(jsonObject.getString("source-type-solver-paths"));
		        	textAreaJARTypeSolverFiles.setText(jsonObject.getString("jar-type-solver-files"));
		        	textAreaPQLProgram.setText(jsonObject.getString("pql-program"));
		        }
		        editingPQLSourceFile = true;
		        currentPQLSourceFile = file.getPath();
		        frmPQLEditor.setTitle("PQL Editor: " + currentPQLSourceFile);
		        textAreaPQLProgram.setEnabled(true);
		        pqlProgramIsDirty = false;
			} catch (Exception e) {
				showErrorMessage("Unexpected error loading PQL program. See console.");
				try (StringWriter sw = new StringWriter();
					 PrintWriter pw = new PrintWriter(sw)) {
						e.printStackTrace(pw);
						addConsoleMessage(sw.toString());
				} catch (Exception e3) {}
			}
		}
	}
	
	private void resetPQLEditor() {
		
    	textSourceCodeFolder.setText("");
    	textTargetCodeFolder.setText("");
    	textAreaSourceTypeSolverPaths.setText("");
    	textAreaJARTypeSolverFiles.setText("");
    	textAreaPQLProgram.setText("");
    	editingPQLSourceFile = false;
    	currentPQLSourceFile = null;
    	frmPQLEditor.setTitle("PQL Editor - No Current File Open");
    	
    	textPaneGeneratedProgram.setText("");
    	listExaminedFiles.removeAll();
    	listModifiedFiles.removeAll();
    	textPaneOriginalSource.setText("");
    	textAreaPQLProgram.setEnabled(false);
    	
    	resetJMeldPanel();
	}
	
	private void resetJMeldPanel() {
        if (jmeldPanel != null) {
        	jmeldPanel = new JMeldPanel();
    		scrollPaneDiff.setViewportView(jmeldPanel);
    		rightTopTabbedPane.setEnabledAt(4, false);
        }		
	}
	
	private void closePQLProgram() {

		if (editingPQLSourceFile && pqlProgramIsDirty && currentPQLSourceFile != null) {
		    int saveResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
		            "Do you want to save the existing PQL file?",
		            "Confirm", JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE);
		    if (saveResponse == JOptionPane.YES_OPTION) {
		    	savePQLProgram();
		    }
		}
		
		resetPQLEditor();

	}
	
	private void newPQLProgram() {

		if (editingPQLSourceFile && pqlProgramIsDirty && currentPQLSourceFile != null) {
		    int saveResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
		            "Do you want to save the existing PQL file?",
		            "Confirm", JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE);
		    if (saveResponse == JOptionPane.YES_OPTION) {
		    	savePQLProgram();
		    }
		}
		
		resetPQLEditor();

		Path newFile = getPQLSaveLocation();
		if (newFile != null) {
			currentPQLSourceFile = newFile.toString();
			editingPQLSourceFile = true;
			savePQLProgram();
			textAreaPQLProgram.setEnabled(true);
			frmPQLEditor.setTitle("PQL Editor: " + currentPQLSourceFile);
			
			currentFileTreePath = FILE_TREE_ROOT_LABEL + "," + newFile.getRoot().toString();
	
			for (int x = 0; x < newFile.getParent().getNameCount(); x++) {
				currentFileTreePath += newFile.getName(x) + ",";
			}
			currentFileTreePath = currentFileTreePath.substring(0, currentFileTreePath.length()-1);
	   		PQLEditor.storeStringPreference(LAST_DIRECTORY_EXPLORER, currentFileTreePath);
	   		
	   		rebuildFileTree();
		}
	}
	
	private void savePQLProgram() {
		
		Path path = null;
		if (currentPQLSourceFile == null) {
			path = getPQLSaveLocation();
		} else {
			path = Paths.get(currentPQLSourceFile);
		}
		
		if (path != null) {
			try (FileWriter fw = new FileWriter(path.toString());
					JsonWriter writer = Json.createWriter(fw)) {
				JsonObject jsonRoot = Json.createObjectBuilder().add("source-code-folder", textSourceCodeFolder.getText())
											.add("target-code-folder", textTargetCodeFolder.getText())
											.add("source-type-solver-paths", textAreaSourceTypeSolverPaths.getText())
											.add("jar-type-solver-files", textAreaJARTypeSolverFiles.getText())
											.add("pql-program", textAreaPQLProgram.getText())
											.build();
				writer.write(jsonRoot);
				pqlProgramIsDirty = false;
			} catch (Exception e) {
				showErrorMessage("Unexpected error saving PQL program. See console.");
				try (StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw)) {
					e.printStackTrace(pw);
					addConsoleMessage(sw.toString());
				} catch (Exception e2) {}
			}
		}
	}
	
	private File getUserChosenPQLFile() {
		
		File result = null;
		
		JFileChooser fc = new JFileChooser();
		String lastDirectory = getStringPreference(LAST_DIRECTORY_DIALOG);
		if (lastDirectory.trim().length() > 0) {
			fc.setCurrentDirectory(Paths.get(lastDirectory).toFile());
		}
		
		fc.setDialogTitle("Open an existing PQL program file.");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*." + PQL_FILE_EXTENSION, PQL_FILE_EXTENSION);
		fc.setFileFilter(filter);

		int returnVal = fc.showOpenDialog(frmPQLEditor);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			result = fc.getSelectedFile();
			if (result != null && result.getParentFile() != null) {
				storeStringPreference(LAST_DIRECTORY_DIALOG, result.getParentFile().toPath().toString());
			}
		} else {
			result = null;
		}
		
		return result;
	}
	
	private Path getPQLSaveLocation() {
		
		Path result = null;
		
		JFileChooser fc = new JFileChooser();
		String lastDirectory = getStringPreference(LAST_DIRECTORY_DIALOG);
		if (lastDirectory.trim().length() > 0) {
			fc.setCurrentDirectory(Paths.get(lastDirectory).toFile());
		}

		fc.setDialogTitle("Save the Current PQL Program");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*." + PQL_FILE_EXTENSION, PQL_FILE_EXTENSION);
		fc.setFileFilter(filter);
		int returnVal = fc.showSaveDialog(frmPQLEditor);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			//Make sure file name ends with the right extension
			if (!file.getName().toLowerCase().endsWith("." + PQL_FILE_EXTENSION)) {
				result = Paths.get(file.toPath().toString() + "." + PQL_FILE_EXTENSION);
			} else {
				result = file.toPath();
			}
			if (result.toFile().exists()) {
				//Ask if ok to replace
			    int fileExistsResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
			            "Do you want to replace the existing file?",
			            "Confirm", JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE);
			    if (fileExistsResponse != JOptionPane.YES_OPTION) {
			        result = null;
			    } 
			}
			if (result != null && result.toFile().getParentFile() != null) {
				storeStringPreference(LAST_DIRECTORY_DIALOG, file.getParentFile().toPath().toString());
			}			
		}
		
		return result;
	}
	
	private void rebuildFileTree() {

		DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) fileTree.getModel().getRoot();

		rootNode.removeAllChildren();
		
		fileTree.fireTreeCollapsed(new TreePath(rootNode.getPath()));
		//fileTree.collapsePath(new TreePath(rootNode.getPath()));

		DefaultTreeModel tm = (DefaultTreeModel) fileTree.getModel();
		tm.reload();

		initializeFileTree();
		
	}
	
	private void initializeFileTree() {

		File[] roots = File.listRoots();
		DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) fileTree.getModel().getRoot();
				
		for (File root : roots) {
			addFileTreeNodes(rootNode, root.toPath());
		}
		
		fileTree.expandPath(new TreePath(rootNode.getPath()));
		
		restoreFileTree();
	}
	
	private DefaultMutableTreeNode findTreeNode(DefaultMutableTreeNode parent, PathTreeNode child) {
		
		DefaultMutableTreeNode result = null;
		DefaultMutableTreeNode nodeX = null;
		PathTreeNode pathNode = null;

		//Yes linear, but that is what JTree does internally using vectors and object equality,
		//which does not work for expanding arbitrary locations in the tree.
		if (parent != null) {
			@SuppressWarnings("unchecked")
			Enumeration<DefaultMutableTreeNode> e =parent.children();
			while (e.hasMoreElements()) {
				nodeX = e.nextElement();
				pathNode = (PathTreeNode) nodeX.getUserObject();
				if (pathNode != null && pathNode.equals(child)) {
					result = nodeX;
					break;
				}
			}
		}
		
		return result;
	}
	
	private void restoreFileTree() {
		try {
			String lastDirectory = getStringPreference(LAST_DIRECTORY_EXPLORER);
			if (lastDirectory != null && lastDirectory.length() > 0) {
				String[] pathComponents = lastDirectory.split(",");
				DefaultMutableTreeNode nodeX = (DefaultMutableTreeNode) fileTree.getModel().getRoot();
				TreePath tp = new TreePath(nodeX);
				for (int componentIndex = 1; componentIndex < pathComponents.length; componentIndex++) {
					nodeX = findTreeNode(nodeX, new PathTreeNode(pathComponents[componentIndex]));
					if (nodeX == null) break;
					tp = tp.pathByAddingChild(nodeX);
					fileTree.fireTreeWillExpand(tp);
				}
				fileTree.expandPath(tp);
			}
		} catch (Exception e) {
			System.out.println("Exception setting last opened directory for file explorer.");
		}
	}
	
	private void addFileTreeNodes(DefaultMutableTreeNode baseNode, Path directoryPath) {
		
		DefaultMutableTreeNode nodeToAdd = null;
		
		File f = null;
		boolean isDirectory = false;
		List<Path> dirFiles = new ArrayList<>();
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(directoryPath)) {
			dirStream.forEach(dirFiles::add);
			dirFiles.sort(Comparator.comparing(Path::toString));
			for (Path pathEntry : dirFiles) {
				f = pathEntry.toFile();
				if (f.canRead() && !f.isHidden()) {
					isDirectory = f.isDirectory();
					if (pathEntry.getNameCount() == 1) {
						nodeToAdd = new DefaultMutableTreeNode(new PathTreeNode(pathEntry.toString()), isDirectory);
					} else {
						nodeToAdd = new DefaultMutableTreeNode(new PathTreeNode(pathEntry.getFileName().toString()), isDirectory);
					}
					baseNode.add(nodeToAdd);
					if (isDirectory) {
						DefaultMutableTreeNode ph = new DefaultMutableTreeNode(new PathTreeNode(TREE_PLACEHOLDER, TREE_PLACEHOLDER), false);
						nodeToAdd.add(ph);
					}
				}
			}
		} catch (AccessDeniedException e1) {
			//Nothing to do
		} catch (IOException e2) {
			showErrorMessage("Unable to add nodes to file tree. See console.");
			try (StringWriter sw = new StringWriter();
				 PrintWriter pw = new PrintWriter(sw)) {
				e2.printStackTrace(pw);
				addConsoleMessage(sw.toString());
			} catch (Exception e3) {}
		}
	}
	
	private void showDiff(Path original, Path target) {
		
		//Important to do this before invoking jmeld, otherwise errors occur
		rightTopTabbedPane.setEnabledAt(4, true);
		rightTopTabbedPane.setSelectedIndex(4);
		
		jmeldPanel.openComparison(original.toString(), target.toString());

		try {
			Field tbf = jmeldPanel.getClass().getDeclaredField("toolBar");
			tbf.setAccessible(true);
			javax.swing.JComponent tb = (javax.swing.JComponent) tbf.get(jmeldPanel);
			tb.getComponent(6).setVisible(false);
			tb.getComponent(7).setVisible(false);
			tb.getComponent(8).setVisible(false);
		} catch (Exception e) {
		}
		
	}

	public void showWarningMessage(String message) {
		JOptionPane.showMessageDialog(frmPQLEditor,
			    message, "PQL Editor",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(frmPQLEditor,
			    message, "PQL Editor",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean askYesNoQuestion(String question) {
		
		boolean result = false;
		
		int fileExistsResponse = JOptionPane.showConfirmDialog(frmPQLEditor,
	            question,
	            "Confirm", JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE);
		
	    if (fileExistsResponse == JOptionPane.YES_OPTION) {
	        result = true;
	    }

	    return result;
	}
	
	private String getTypeSolverJARS() {
		
		String result = "";
		
		if (textAreaJARTypeSolverFiles.getText() != null && textAreaJARTypeSolverFiles.getText().trim().length() > 0) {
			String jars[] = textAreaJARTypeSolverFiles.getText().split("\\n");
			for (int x = 0; x < jars.length; x++) {
				result += jars[x].trim() + ';';
			}
			result = result.substring(0, result.length() - 1);
		}
		
		return result;
	}

	private String getSourceTypeSolverPaths() {
		
		String result = "";
		
		if (textAreaSourceTypeSolverPaths.getText() != null && textAreaSourceTypeSolverPaths.getText().trim().length() > 0) {
			String paths[] = textAreaSourceTypeSolverPaths.getText().split("\\n");
			for (int x = 0; x < paths.length; x++) {
				result += paths[x].trim() + ';';
			}
			result = result.substring(0, result.length() - 1);
		}
		
		return result;
	}
	
	private String getTimestamp() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss (yyyy-MM-dd)");
		return sdf.format(new Date());

	}

	@SuppressWarnings("unused")
	private boolean deleteDirectory(File directoryToBeDeleted) {
	    File[] allContents = directoryToBeDeleted.listFiles();
	    if (allContents != null) {
	        for (File file : allContents) {
	            deleteDirectory(file);
	        }
	    }
	    return directoryToBeDeleted.delete();
	}

	private void runPQLProgram() {
		
		if (textSourceCodeFolder.getText() == null || textSourceCodeFolder.getText().trim().length() == 0) {
			showWarningMessage("You must provide the location for the source code to analyze.");
			return;
		}

		if (textTargetCodeFolder.getText() == null || textTargetCodeFolder.getText().trim().length() == 0) {
			showWarningMessage("You must provide the location where you want PQL to save changes.");
			return;
		}
		
		rightBottomTabbedPane.setSelectedIndex(0);
		
		String sourceToExamine = textSourceCodeFolder.getText();
		String targetForModifications = textTargetCodeFolder.getText();
		String jarTypeSolverFiles = getTypeSolverJARS();
		String sourceTypeSolverPaths = getSourceTypeSolverPaths();

		if (Paths.get(sourceToExamine).equals(Paths.get(targetForModifications))) {
			if (!askYesNoQuestion("Source and target directories are the same.\nThis " +
					" will result in changes made to the source directory. " +
					"\n\nAre you sure?")) {
				return;
			}
		}

			
		modelExaminedFiles.clear();
		modelModifiedFiles.clear();

		resetJMeldPanel();
		
		addConsoleMessage("###Compile and Run PQL Program: " + getTimestamp() + "###");
		
		if (!generatePQLProgram(true)) {
			return;
		}

		addConsoleMessage("Running PQL ...", false);
		
		pqlResult = null;

		try {
			this.mntmRunPql.setEnabled(false);
			pqlResult = invokePQLProgram(sourceToExamine, targetForModifications, sourceTypeSolverPaths, jarTypeSolverFiles);
			if (pqlResult != null) {
				addConsoleMessage("done.");
				showExaminedFiles(pqlResult);
				showModifiedFiles(pqlResult);
				addConsoleMessage("\n---PQL Execution Summary---");
				addConsoleMessage(pqlResult.getExaminedFiles().size() + " file(s) examined.");
				addConsoleMessage(pqlResult.getMatchedFiles().size() + " file(s) matched.");
				addConsoleMessage(pqlResult.getModifiedFiles().keySet().size() + " file(s) modified.");
				showOutput(pqlResult);
			} else {
				addConsoleMessage("failed.");
				throw new Exception("PQL program was executed but returned no results.");
			}
		} catch (Exception e) {
			addConsoleMessage("failed.");
			showErrorMessage("Unexpected error running PQL program. See console.");
			try (StringWriter sw = new StringWriter();
				 PrintWriter pw = new PrintWriter(sw)) {
					e.printStackTrace(pw);
					addConsoleMessage(sw.toString());
			} catch (Exception e3) {}
		} finally {
			this.mntmRunPql.setEnabled(true);
		}
	}
	
	public PQLExecutionResult invokePQLProgram(String sourceToExamine, String targetForModifications, 
			String sourceTypeSolverPaths, String jarTypeSolverFiles) throws Exception {
		
		PQLExecutionResult pqlResult = null;
		
		try {
			Class<? extends IPQLProgram> pqlProgramClass = Class.forName(PQL_PROGRAM_CLASS_NAME + compilationIndex).asSubclass(IPQLProgram.class);
			Constructor<? extends IPQLProgram> constructor = pqlProgramClass.getConstructor();
			IPQLProgram pqlProgram = constructor.newInstance();

			pqlResult = pqlProgram.run(sourceToExamine, targetForModifications, sourceTypeSolverPaths, jarTypeSolverFiles);
		} catch (Exception e) {
			throw e;
		}
		
		return pqlResult;
	}
		
	private void showExaminedFiles(PQLExecutionResult pqlResult) {
		
		for (Path p : pqlResult.getExaminedFiles()) {
			modelExaminedFiles.addElement(p.toString());
		}
	}

	private void showOriginalSource(String path) {
		
		try {
			String source = new String(Files.readAllBytes(Paths.get(path)));
			String formattedSource = getFormattedSourceCode(source);
			textPaneOriginalSource.setText(formattedSource);
			rightTopTabbedPane.setSelectedIndex(3);
		} catch (Exception e) {
			showWarningMessage("Unexpected error showing original source for selected file. See console.");
			try (StringWriter sw = new StringWriter();
				 PrintWriter pw = new PrintWriter(sw)) {
					e.printStackTrace(pw);
					addConsoleMessage(sw.toString());
			} catch (Exception e3) {}
		}
	}

	private void showModifiedFiles(PQLExecutionResult pqlResult) {
		
		for (Path p : pqlResult.getModifiedFiles().keySet()) {
			modelModifiedFiles.addElement(p.toString());
		}
	}

	private void showOutput(PQLExecutionResult pqlResult) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n---Begin Output---\n");
		
		int outputIndex = 1;
		for (Map.Entry<Path, String> e : pqlResult.getFileOutput().entrySet()) {
			sb.append(String.format("\n***Item %d***\n", outputIndex))
				.append(e.getValue()).append(System.lineSeparator())
				.append(String.format("***End Item %d***\n", outputIndex++));
		}
		
		sb.append("\n###Problems###\n");
		
		if (pqlResult.getMessages().isEmpty()) {
			sb.append("None\n");
		} else {
			pqlResult.getMessages().forEach(m -> sb.append(m + System.lineSeparator()));
		}
		
		sb.append("\n---End Output---\n");
		
		addConsoleMessage(sb.toString());
	}
	
	private void addConsoleMessage(String message) {
		
		addConsoleMessage(message, true);
	}
	
	private void addConsoleMessage(String message, boolean addNewLine) {
		
		if (message != null) {
			if (addNewLine) {
				textAreaConsole.append(message + System.lineSeparator());
			} else {
				textAreaConsole.append(message);
			}
		}
	}

	private void setFolderLocation(JTextField target) {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose Folder");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	target.setText(chooser.getSelectedFile().getPath());
	    }
	}

	private void setFolderLocation(JTextArea target) {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose Folder");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	target.setText(chooser.getSelectedFile().getPath());
	    }
	}
	
	private void setFileLocation(JTextArea target) {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose JAR File");
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    	target.append(chooser.getSelectedFile().getPath() + "\n");
	    }
	}

	private void clearConsoleMessages() {
		textAreaConsole.setText("");
	}
	
	public void showPQLParseTree() {
		
		
	}
	
	public boolean generatePQLProgram(boolean callFromRunPQL) {
		
		boolean result = false;
		
		rightBottomTabbedPane.setSelectedIndex(0);
		
		String pqlSource = textAreaPQLProgram.getText();
						
		try {
			this.mntmParsePql.setEnabled(false);

			if (!callFromRunPQL) {
				addConsoleMessage("###Compile PQL Program: " + getTimestamp() + "###");
			}
			
			PQLProgramGenerator ppg = new PQLProgramGenerator();

			addConsoleMessage("Parsing PQL ...", false);
			PQLProgramResult pqlProgramResult = null;
			
			try {
			    compilationIndex += 1;
			    pqlProgramResult = ppg.generatePQLProgram(pqlSource, (PQL_PROGRAM_CLASS_NAME + compilationIndex));
				addConsoleMessage("done.");
			} catch (Exception e) {
				addConsoleMessage("failed.");
				throw e;
			}
			
			//Use this to show code in plain text
			//textPaneGeneratedProgram.setContentType("text/plain");
			//textPaneGeneratedProgram.setText(generatedProgram);
			
			//Use this to format code for display
			addConsoleMessage("Formatting generated code ...", false);
			String formattedProgram = getFormattedSourceCode(pqlProgramResult.getPqlProgram());
			textPaneGeneratedProgram.setContentType("text/html");
			textPaneGeneratedProgram.setText(formattedProgram);
			
			TreeViewer treeViewer = new TreeViewer(Arrays.asList(pqlProgramResult.getParser().getRuleNames()), pqlProgramResult.getParseTree());
			treeViewer.setScale(1.0);
			pqlParseTreeScroll.setViewportView(treeViewer);
			pqlParseTreeScroll.revalidate();
			
			addConsoleMessage("done.");

			addConsoleMessage("Compiling program ...", false);
			try {
				compilePQLProgram(pqlProgramResult.getPqlProgram());
				addConsoleMessage("done.\n");
				result = true;
			} catch (Exception e) {
				addConsoleMessage("failed.\n");
				throw e;
			}
		} catch (Exception e) {
			showWarningMessage("Unexpected error generating program from PQL source. See console.");
			try (StringWriter sw = new StringWriter();
				 PrintWriter pw = new PrintWriter(sw)) {
					e.printStackTrace(pw);
					addConsoleMessage(sw.toString());
			} catch (Exception e3) {}
		} finally {
			this.mntmParsePql.setEnabled(true);
		}
		
		return result;
	}

	private String getCompilationErrors(DiagnosticCollector<JavaFileObject> diagnostics) {

    	StringBuilder diagMessage = new StringBuilder();
        
    	for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
        	diagMessage.append(diagnostic.toString() + System.lineSeparator());
        }
        
        return diagMessage.toString();
	}
	
	private void compilePQLProgram(String pqlProgram) throws Exception {
		
		Path sourceFile = null;
		Path existingClass = null;
		FileWriter writer = null;
		StandardJavaFileManager fileManager = null;
		DiagnosticCollector<JavaFileObject> diagnostics = null;
		
		try {
		    //Get class folder
		    File targetClassFolder = (new File(PQLEditor.class.getResource(this.getClass().getSimpleName() +  ".class").getPath())).getParentFile();

		    if (compilationIndex > 1) {
				sourceFile = Paths.get(targetClassFolder.getPath(), PQL_PROGRAM_CLASS_NAME + (compilationIndex-1) + ".java");
				Files.deleteIfExists(sourceFile);
				existingClass = Paths.get(targetClassFolder.getPath(), PQL_PROGRAM_CLASS_NAME + (compilationIndex-1) + ".class");
				Files.deleteIfExists(existingClass);
		    }
		    		    
			sourceFile = Paths.get(targetClassFolder.getPath(), PQL_PROGRAM_CLASS_NAME + compilationIndex + ".java");

			Files.deleteIfExists(sourceFile);
			
		    writer = new FileWriter(sourceFile.toFile());

		    writer.write(pqlProgram);
		    writer.close();
		    writer = null;
			
		    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		    
		    diagnostics = new DiagnosticCollector<JavaFileObject>();
		    
		    fileManager = compiler.getStandardFileManager(diagnostics, Locale.getDefault(), null);
		    
		    existingClass = Paths.get(targetClassFolder.getPath(), PQL_PROGRAM_CLASS_NAME + compilationIndex + ".class");

		    Files.deleteIfExists(existingClass);

		    fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(targetClassFolder));

		    // Compile the file
		    boolean compileIsSuccess = compiler.getTask(null, fileManager, diagnostics, Arrays.asList("-g"), null,
	    			fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile.toFile())))
	    			.call();
		    
	        if (!compileIsSuccess) {
	        	String compilationErrors = getCompilationErrors(diagnostics);
	        	diagnostics = null;
	        	throw new Exception("Compilation errors: \n" + compilationErrors);
	        }
		} catch (Exception e) {
			if (diagnostics != null && diagnostics.getDiagnostics() != null) {
				String compilationErrors = getCompilationErrors(diagnostics);
				throw new Exception(compilationErrors, e);
			} else {
				throw e;
			}
		} finally {
			if (fileManager != null) {
				fileManager.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	public String getFormattedSourceCode(String sourceCode) {
		
	    if (sourceCode != null) {
	        try {
	            JavaSource source = new JavaSourceParser().parse(new StringReader(sourceCode));
	            JavaSource2HTMLConverter converter = new JavaSource2HTMLConverter();
	            StringWriter writer = new StringWriter();
	            JavaSourceConversionOptions options = JavaSourceConversionOptions.getDefault();
	            //options.setShowLineNumbers(true);
	            options.setAddLineAnchors(false);
	            converter.convert(source, options, writer);
	            return writer.toString();
	        } catch (IllegalConfigurationException | IOException exception) {
	        	//Do nothing (return source code as is, which is fine)
	        }
	    }
	    
	    return sourceCode;
	}
	
	private static String getStringPreference(String key) {
		
		return preferences.get(key, "");
	}
	
	private static void storeStringPreference(String key, String value) {
		
		try {
			preferences.put(key, value);
			preferences.flush();
		} catch (BackingStoreException e) {
			System.out.println("Unabled to store system preference.");
		}
	}
	
	class ListenForAnyUpdate implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			pqlProgramIsDirty = true;
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			pqlProgramIsDirty = true;
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			pqlProgramIsDirty = true;
		}
	}
	
	private int compilationIndex = 0;
	private static Preferences preferences = Preferences.userNodeForPackage(PQLEditor.class);
	
	private static final String LAST_DIRECTORY_DIALOG = "LAST_DIRECTORY_DIALOG";
	private static final String LAST_DIRECTORY_EXPLORER = "LAST_DIRECTORY_EXPLORER";
	
	private boolean editingPQLSourceFile = false;
	private String currentPQLSourceFile = null;
	
	private JTextArea textAreaPQLProgram;
	private JTextPane textPaneGeneratedProgram;
	private JList<String> listExaminedFiles;
	private JList<String> listModifiedFiles;
	
	DefaultListModel<String> modelExaminedFiles;
	DefaultListModel<String> modelModifiedFiles;
	private JTextPane textPaneOriginalSource;
	private JTextArea textAreaConsole;
	private PQLExecutionResult pqlResult;
	private JTabbedPane rightBottomTabbedPane;
	private JTextField textSourceCodeFolder;
	private JTextField textTargetCodeFolder;
	private JTextArea textAreaJARTypeSolverFiles;
	private JTextArea textAreaSourceTypeSolverPaths;
	private JMeldPanel jmeldPanel;
	private JScrollPane scrollPaneDiff;
	private static final String PQL_PROGRAM_CLASS_NAME = "PQLProgram";
	private static final String PQL_FILE_EXTENSION = "pql";
	private JMenuItem mntmParsePql;
	private JMenuItem mntmRunPql;
	private JTree fileTree;
	private static final String TREE_PLACEHOLDER = "TREE_PLACEHOLDER";
	private static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private JTabbedPane rightTopTabbedPane;
	private JTabbedPane leftTopTabbedPane;
	private JTabbedPane leftBottomTabbedPane;
	private static final String FILE_TREE_ROOT_LABEL = "files";
	private static final PathTreeNode FILE_TREE_ROOT_USER_OBJECT = new PathTreeNode(FILE_TREE_ROOT_LABEL);
	private static String currentFileTreePath = null;
	private boolean pqlProgramIsDirty = false;
	JPanel pnlPQLParseTreeTab;
	JScrollPane pqlParseTreeScroll;
}
