package test.IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import test.TypeCarburant;
import test.TypeCarburantTransaction;
import test.User;
import test.UserTransaction;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ChauffeursInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField PrenomField;
	private JTextField NomField;
	private JTextField CodeField;
	private JTextField GradeField;
	
	private JTable chauffeursTable;
	
	private List<User> chauffeurs = new ArrayList<User>();
	private int idItemSelected;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChauffeursInterface frame = new ChauffeursInterface();
					frame.setResizable(false);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	//method to clear the txt fields
    private void clear() {
    	NomField.setText("");
    	PrenomField.setText("");
    	CodeField.setText("");
    	GradeField.setText("");
    	
    }
    
    
    // fonction permet la mise a jour du tableau des Types carburants
    
    private void fetch() {
    	chauffeurs.clear();
    	try {
			UserTransaction UT = new UserTransaction();
			chauffeurs = UT.getAll();
			if(chauffeurs != null) {
			DefaultTableModel model = (DefaultTableModel) chauffeursTable.getModel();
            for (User item : chauffeurs) {

                Object[] row = new Object[8];
                row[0] = item.getId();
                row[1] = item.getNom();
                row[2] = item.getPrenom();
                row[3] = item.getLogin();
                row[4] = item.getPassword();
                row[5] = item.getCode();
                row[6] = item.getGrade();
                row[7] = item.getType();
               

                model.addRow(row);
            }
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
	
    // deux fonctions pour afficher les message : 
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }
	
	@SuppressWarnings("serial")
	public ChauffeursInterface() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
	
	
		
		// Tabulations (Mission - Vehicule - Chauffeur - Type carburant ):
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		// Mission Tab :
		JPanel mission = new JPanel();
		tabbedPane.addTab("Missions", null, mission, null);
		mission.setLayout(null);
		
		// Vehicule Tab :
		JPanel vehicule = new JPanel();
		tabbedPane.addTab("Véhicules", null, vehicule, null);
		
		// Chauffeur Tab :
		JPanel chauffeur = new JPanel();
		tabbedPane.addTab("Chauffeurs", null, chauffeur, null);

		// Type carburant Tab
		JPanel carburant = new JPanel();
		tabbedPane.addTab("Types Carburants", null, carburant, null);
		carburant.setLayout(null);
		chauffeur.setLayout(null);
		
		JPanel Create = new JPanel();
		Create.setBounds(0, 0, 300, 600);
		chauffeur.add(Create);
		Create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(30, 20, 90, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		Create.add(lblNewLabel);
		
		NomField = new JTextField();
		NomField.setBounds(120, 20, 120, 25);
		Create.add(NomField);
		NomField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(30, 60, 90, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		Create.add(lblNewLabel_1);
		
		PrenomField = new JTextField();
		PrenomField.setBounds(120, 60, 120, 25);
		PrenomField.setColumns(10);
		Create.add(PrenomField);
		
		// Buttons et leurs actions :
		
		JButton ButtonAjouter = new JButton("Ajouter");
		ButtonAjouter.setBounds(10, 250, 85, 21);
		ButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
            
            private void btnAjouterActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
            	String nom = NomField.getText().trim();
                String prenom = PrenomField.getText().trim();
                String code = CodeField.getText().trim();
                String grade = GradeField.getText().trim();
                
                
                if(!nom.isEmpty() && !prenom.isEmpty() && !code.isEmpty() && !grade.isEmpty() ) {
                	
                	try {
						UserTransaction UT = new UserTransaction();
						User user = UT.getByCode(code);
						if(user == null) {

							UT.save(new User(nom, prenom, null, null, code, grade, "CHAUFFEUR"));
							 DefaultTableModel model = (DefaultTableModel) chauffeursTable.getModel();
			                    Object[] row = new Object[8];
			                    row[0] = UT.getByCode(code).getId();
			                    row[1] = nom;
			                    row[2] = prenom;
			                    row[3] = null;
			                    row[4] = null;
			                    row[5] = code;
			                    row[6] = grade;
			                    row[7] = "CHAUFFEUR";
			                    
			                    model.addRow(row);
							
							
						}else {	
							alert("Please provide a different chauffeur", " Similar chauffeur found");
						}
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	// vider les champs :
                	clear();
                	
                	
                }else {
                    alert("please fill in all the details");
                }
                
                
			}

        });
		Create.add(ButtonAjouter);
		
		JButton ButtonModifier = new JButton("Modifier");
		ButtonModifier.setBounds(110, 250, 85, 21);
		ButtonModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnModifierActionPerformed(evt);
			}
			
			private void btnModifierActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String nom = NomField.getText().trim();
                String prenom = PrenomField.getText().trim();
                String code = CodeField.getText().trim();
                String grade = GradeField.getText().trim();
                
                if(!nom.isEmpty() && !prenom.isEmpty() && !code.isEmpty() && !grade.isEmpty()){
                	
                	try {
                		UserTransaction UT = new UserTransaction();
						User user = UT.getById(idItemSelected);
						if(user != null) {

							UT.update(new User(nom, prenom, null, null, code, grade, "CHAUFFEUR"), idItemSelected);
							DefaultTableModel model = (DefaultTableModel) chauffeursTable.getModel();
		                    model.setRowCount(0);                   
		                    fetch();
		                    alert("Update was successful");
							clear();
							
						}else {
		                    alert("There is no such student", "Update error");
		                    clear();
		                }
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                	
                	
                }else {
                    alert("There is nothing to update :(","No row selected");
                    clear();
                }
                
			}

		});
		Create.add(ButtonModifier);
		
		
		JButton ButtonSupprimer = new JButton("Supprimer");
		ButtonSupprimer.setBounds(210, 250, 85, 21);
		ButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
            
            private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
            	int Nrow = chauffeursTable.getSelectedRow();
            	if (Nrow >= 0) {
                    int option = JOptionPane.showConfirmDialog(rootPane,
                            "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        TableModel model = chauffeursTable.getModel();

                        String code = model.getValueAt(Nrow, 5).toString();
                       
                        if (chauffeursTable.getSelectedRows().length == 1) {
 	
                        	try {
                        		UserTransaction UT = new UserTransaction();
                        	            		 
                        		UT.delete(UT.getByCode(code).getId());
                        		clear();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

                            DefaultTableModel model1 = (DefaultTableModel) chauffeursTable.getModel();
                            model1.setRowCount(0);
                            fetch();
                            
                        }
                    }
                } else {
                    alert("Please select a row to delete");
                }
            }
        });
		Create.add(ButtonSupprimer);
		
		JLabel lblNewLabel_2 = new JLabel("Code");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 100, 90, 25);
		Create.add(lblNewLabel_2);
		
		CodeField = new JTextField();
		CodeField.setColumns(10);
		CodeField.setBounds(120, 100, 120, 25);
		Create.add(CodeField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Grade");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(30, 140, 90, 25);
		Create.add(lblNewLabel_2_1);
		
		GradeField = new JTextField();
		GradeField.setColumns(10);
		GradeField.setBounds(120, 140, 120, 25);
		Create.add(GradeField);
		
		JPanel Display = new JPanel();
		Display.setBounds(300, 5, 600, 600);
		chauffeur.add(Display);
		Display.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 600);
		Display.add(scrollPane);

		
		// Tableau d'affichage des Types de carburants : 
		chauffeursTable = new JTable();
		chauffeursTable.setBounds(100, 50, 400, 500);
		chauffeursTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Id", "nom", "prenom", "login", "password", "code", "grade", "type"
	            }
	        ) {
	            /**
				 * 
				 */
				boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
				chauffeursTable.setCellSelectionEnabled(true);
				chauffeursTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	typesCarburantsTableMouseClicked(evt);
	            }
	            private void typesCarburantsTableMouseClicked(java.awt.event.MouseEvent evt) {
	            	int c = chauffeursTable.getSelectedRow();
	            	TableModel model = chauffeursTable.getModel();
	            	idItemSelected = Integer.parseInt(model.getValueAt(c, 0).toString());
	            	NomField.setText(model.getValueAt(c, 1).toString());
	            	PrenomField.setText(model.getValueAt(c, 2).toString());
	            	CodeField.setText(model.getValueAt(c, 5).toString());
	            	GradeField.setText(model.getValueAt(c, 6).toString());
	            }
	            
	        });

		scrollPane.setViewportView(chauffeursTable);
		
		fetch();
		
		
		
		
		
		
		
	}
}
