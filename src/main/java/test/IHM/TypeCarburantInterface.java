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

public class TypeCarburantInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField prixField;
	private JTextField LibelleField;
	private JTable typesCarburantsTable;
	private List<TypeCarburant> carburants = new ArrayList<TypeCarburant>();
	private int idItemSelected;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeCarburantInterface frame = new TypeCarburantInterface();
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
    	LibelleField.setText("");
    	prixField.setText("");
    }
    
    
    // fonction permet la mise a jour du tableau des Types carburants
    
    private void fetch() {
    	carburants.clear();
    	try {
			TypeCarburantTransaction TCT = new TypeCarburantTransaction();
			carburants = TCT.getAll();
			
			DefaultTableModel model = (DefaultTableModel) typesCarburantsTable.getModel();
            for (TypeCarburant item : carburants) {

                Object[] row = new Object[4];
                row[0] = item.getId();
                row[1] = item.getLibelle();
                row[2] = item.getPrix();

                model.addRow(row);
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
	public TypeCarburantInterface() {
		
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
		
		JPanel Create = new JPanel();
		Create.setBounds(0, 0, 300, 600);
		carburant.add(Create);
		Create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Libelle");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 65, 90, 25);
		Create.add(lblNewLabel);
		
		LibelleField = new JTextField();
		LibelleField.setBounds(120, 65, 120, 25);
		Create.add(LibelleField);
		LibelleField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prix (DH/L)");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(25, 100, 90, 25);
		Create.add(lblNewLabel_1);
		
		prixField = new JTextField();
		prixField.setColumns(10);
		prixField.setBounds(120, 100, 120, 25);
		Create.add(prixField);
		
		// Buttons et leurs actions :
		
		JButton ButtonAjouter = new JButton("Ajouter");
		ButtonAjouter.setBounds(10, 200, 85, 21);
		ButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
            
            private void btnAjouterActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
            	String libelle = LibelleField.getText().trim();
                String prix = prixField.getText().trim();
                
                if(!libelle.isEmpty() && !prix.isEmpty()) {
                	
                	try {
						TypeCarburantTransaction TCT = new TypeCarburantTransaction();
						TypeCarburant carburant = TCT.getByLibelle(libelle);
						if(carburant == null) {

							TCT.save(new TypeCarburant(libelle, prix));
							 DefaultTableModel model = (DefaultTableModel) typesCarburantsTable.getModel();
			                    Object[] row = new Object[4];
			                    row[0] = TCT.getByLibelle(libelle).getId();
			                    row[1] = libelle;
			                    row[2] = prix;
			                    model.addRow(row);
							
							
						}else {	
							alert("Please provide a different TypeCarburant", " Similar TypeCarburant found");
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
		ButtonModifier.setBounds(105, 200, 85, 21);
		ButtonModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnModifierActionPerformed(evt);
			}
			
			private void btnModifierActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
            	String libelle = LibelleField.getText().trim();
                String prix = prixField.getText().trim();

                
                if(!libelle.isEmpty() && !prix.isEmpty()) {
                	
                	try {
						TypeCarburantTransaction TCT = new TypeCarburantTransaction();
						TypeCarburant carburant = TCT.getById(idItemSelected);
						if(carburant != null) {

							TCT.update(new TypeCarburant(libelle, prix), idItemSelected);
							DefaultTableModel model = (DefaultTableModel) typesCarburantsTable.getModel();
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
		ButtonSupprimer.setBounds(205, 200, 85, 21);
		ButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
            
            private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
            	int Nrow = typesCarburantsTable.getSelectedRow();
            	if (Nrow >= 0) {
                    int option = JOptionPane.showConfirmDialog(rootPane,
                            "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        TableModel model = typesCarburantsTable.getModel();

                        String libelle = model.getValueAt(Nrow, 1).toString();
                       
                        if (typesCarburantsTable.getSelectedRows().length == 1) {
 	
                        	try {
                        		TypeCarburantTransaction TCT = new TypeCarburantTransaction();
                        	            		 
								 TCT.delete(TCT.getByLibelle(libelle).getId());
								 clear();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

                            DefaultTableModel model1 = (DefaultTableModel) typesCarburantsTable.getModel();
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
		
		JPanel Display = new JPanel();
		Display.setBounds(300, 0, 600, 600);
		carburant.add(Display);
		Display.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 600);
		Display.add(scrollPane);

		
		// Tableau d'affichage des Types de carburants : 
		typesCarburantsTable = new JTable();
		typesCarburantsTable.setBounds(100, 50, 400, 500);
		typesCarburantsTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Id", "Libelle", "Prix (DH/L)"
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
			typesCarburantsTable.setCellSelectionEnabled(true);
			typesCarburantsTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	typesCarburantsTableMouseClicked(evt);
	            }
	            private void typesCarburantsTableMouseClicked(java.awt.event.MouseEvent evt) {
	            	int c = typesCarburantsTable.getSelectedRow();
	            	TableModel model = typesCarburantsTable.getModel();
	            	idItemSelected = Integer.parseInt(model.getValueAt(c, 0).toString());
	            	LibelleField.setText(model.getValueAt(c, 1).toString());
	            	prixField.setText(model.getValueAt(c, 2).toString());
	            }
	            
	        });

		scrollPane.setViewportView(typesCarburantsTable);
		
		fetch();
		
		
		
		
		
		
		
	}
}
