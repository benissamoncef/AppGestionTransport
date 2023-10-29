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
import test.Vehicule;
import test.VehiculeTransaction;

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
import javax.swing.JList;
import javax.swing.JComboBox;

public class VehiculesInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField NumeroField;
	private JTextField ModelField;
	private JTextField MarqueField;
	private JTextField CapaciteField;
	private JTextField NombrePlacesField;
	
	private JTable VehiculesTable;
	
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();
	private int idItemSelected;

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehiculesInterface frame = new VehiculesInterface();
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
    	NumeroField.setText("");
    	ModelField.setText("");
    	MarqueField.setText("");
    	CapaciteField.setText("");
    	NombrePlacesField.setText("");
    }
    
    
    // fonction permet la mise a jour du tableau des Types carburants
    
    private void fetch() {
    	vehicules.clear();
    	try {
			VehiculeTransaction UT = new VehiculeTransaction();
			vehicules = UT.getAll();
			if(vehicules != null) {
			DefaultTableModel model = (DefaultTableModel) VehiculesTable.getModel();
            for (Vehicule item : vehicules) {

                Object[] row = new Object[8];
                row[0] = item.getId();
                row[1] = item.getNumero();
                row[2] = item.getModel();
                row[3] = item.getMarque();
                row[4] = item.getType();
                row[5] = item.getCapaciteReservoir();
                row[6] = item.getNombrePlaces();
                row[7] = item.getTypeCarburant();

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
	public VehiculesInterface() {
		
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
		vehicule.setLayout(null);
		
		JPanel Create = new JPanel();
		Create.setBounds(0, 0, 300, 600);
		vehicule.add(Create);
		Create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(30, 20, 90, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		Create.add(lblNewLabel);
		
		NumeroField = new JTextField();
		NumeroField.setBounds(140, 20, 120, 25);
		Create.add(NumeroField);
		NumeroField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Model");
		lblNewLabel_1.setBounds(30, 60, 90, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		Create.add(lblNewLabel_1);
		
		ModelField = new JTextField();
		ModelField.setBounds(140, 60, 120, 25);
		ModelField.setColumns(10);
		Create.add(ModelField);
		
		
		JLabel lblNewLabel_2 = new JLabel("Marque");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 100, 90, 25);
		Create.add(lblNewLabel_2);
		
		MarqueField = new JTextField();
		MarqueField.setColumns(10);
		MarqueField.setBounds(140, 100, 120, 25);
		Create.add(MarqueField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Type");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(30, 140, 90, 25);
		Create.add(lblNewLabel_2_1);
		
		@SuppressWarnings("unchecked")
		final JComboBox TypeSelect = new JComboBox(new String[] {"CAMION", "BUS"});
		TypeSelect.setBounds(140, 144, 120, 25);
		Create.add(TypeSelect);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("CapaciteRes");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(30, 180, 110, 25);
		Create.add(lblNewLabel_2_1_1);
		

		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("NbrPlaces");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(30, 220, 110, 25);
		Create.add(lblNewLabel_2_1_1_1);
		

		JLabel Se = new JLabel("TypeCarburant");
		Se.setFont(new Font("Arial", Font.PLAIN, 16));
		Se.setBounds(30, 260, 110, 25);
		Create.add(Se);
		
		// charger tous les types du carburant dans le menu select dans l'insersion du vehicule :
				TypeCarburantTransaction TCT = null;
				List<TypeCarburant> C = new ArrayList<TypeCarburant>();
				try {
					TCT = new TypeCarburantTransaction();
					 C = TCT.getAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String[] vs = new String[C.size()];
				for(int i = 0; i < C.size(); i++) {
					vs[i] = C.get(i).getLibelle();
				}
		
		@SuppressWarnings("rawtypes")
		
		final JComboBox CarburantSelect = new JComboBox(vs);
		CarburantSelect.setBounds(140, 260, 120, 25);
		Create.add(CarburantSelect);
		
			
		
		// Buttons et leurs actions :
		
		JButton ButtonAjouter = new JButton("Ajouter");
		ButtonAjouter.setBounds(10, 350, 85, 21);
		ButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
            
            private void btnAjouterActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
            	String numero = NumeroField.getText().trim();
                String model = ModelField.getText().trim();
                String marque = MarqueField.getText().trim();
                String capacite = CapaciteField.getText().trim();
                String nombrePlaces = NombrePlacesField.getText().trim();
                String type = TypeSelect.getSelectedItem().toString();
                String TypeCarb = CarburantSelect.getSelectedItem().toString(); 
                
                if(!numero.isEmpty() && !model.isEmpty() && !marque.isEmpty() && !capacite.isEmpty() && !nombrePlaces.isEmpty() && !type.isEmpty() && !TypeCarb.isEmpty() ) {
                	
                	try {
						VehiculeTransaction VT = new VehiculeTransaction();
						TypeCarburantTransaction TCT = new TypeCarburantTransaction();
						Vehicule v = VT.getByNumero(numero);
						if(v == null) {

							VT.save(new Vehicule(numero, model, marque, capacite, nombrePlaces, type, TCT.getByLibelle(TypeCarb).getId()));
							 DefaultTableModel model1 = (DefaultTableModel) VehiculesTable.getModel();
			                    Object[] row = new Object[8];
			                    row[0] = VT.getByNumero(numero).getId();
			                    row[1] = numero;
			                    row[2] = model;
			                    row[3] = marque;
			                    row[4] = capacite;
			                    row[5] = nombrePlaces;
			                    row[6] = type;
			                    row[7] = TypeCarb;
			                    
			                    model1.addRow(row);
							
							
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
		ButtonModifier.setBounds(110, 350, 85, 21);
		ButtonModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnModifierActionPerformed(evt);
			}
			
			private void btnModifierActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				String numero = NumeroField.getText().trim();
                String model = ModelField.getText().trim();
                String marque = MarqueField.getText().trim();
                String capacite = CapaciteField.getText().trim();
                String nombrePlaces = NombrePlacesField.getText().trim();
                String type = TypeSelect.getSelectedItem().toString();
                String TypeCarb = CarburantSelect.getSelectedItem().toString(); 
                
                if(!numero.isEmpty() && !model.isEmpty() && !marque.isEmpty() && !capacite.isEmpty() && !nombrePlaces.isEmpty() && !type.isEmpty() && !TypeCarb.isEmpty() ){
                	
                	try {
                		VehiculeTransaction UT = new VehiculeTransaction();
                		TypeCarburantTransaction TCT = new TypeCarburantTransaction();
						Vehicule v = UT.getById(idItemSelected);
						if(v != null) {

							UT.update(new Vehicule(numero, model, marque, capacite, nombrePlaces, type, TCT.getByLibelle(TypeCarb).getId()), idItemSelected);
							DefaultTableModel model1 = (DefaultTableModel) VehiculesTable.getModel();
		                    model1.setRowCount(0);                   
		                    fetch();
		                    alert("Update was successful");
							clear();
							
						}else {
		                    alert("There is no such Vehicule", "Update error");
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
		ButtonSupprimer.setBounds(210, 350, 85, 21);
		ButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
            
            private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
            	int Nrow = VehiculesTable.getSelectedRow();
            	if (Nrow >= 0) {
                    int option = JOptionPane.showConfirmDialog(rootPane,
                            "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                        TableModel model = VehiculesTable.getModel();

                        String numero = model.getValueAt(Nrow, 1).toString();
                       
                        if (VehiculesTable.getSelectedRows().length == 1) {
 	
                        	try {
                        		VehiculeTransaction VT = new VehiculeTransaction();
                        	            		 
                        		VT.delete(VT.getByNumero(numero).getId());
                        		clear();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

                            DefaultTableModel model1 = (DefaultTableModel) VehiculesTable.getModel();
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
		
		CapaciteField = new JTextField();
		CapaciteField.setColumns(10);
		CapaciteField.setBounds(140, 180, 120, 25);
		Create.add(CapaciteField);
		
		NombrePlacesField = new JTextField();
		NombrePlacesField.setColumns(10);
		NombrePlacesField.setBounds(140, 220, 120, 25);
		Create.add(NombrePlacesField);
		
	
		
	
		JPanel Display = new JPanel();
		Display.setBounds(300, 0, 600, 600);
		vehicule.add(Display);
		Display.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 600);
		Display.add(scrollPane);

		
		// Tableau d'affichage des Types de carburants : 
		VehiculesTable = new JTable();
		VehiculesTable.setBounds(100, 50, 400, 500);
		VehiculesTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	            		"id", "numero", "model", "marque", "type", "capaciteRes", "nombrePlaces", "Tcarburant" 	
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
				VehiculesTable.setCellSelectionEnabled(true);
				VehiculesTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	typesCarburantsTableMouseClicked(evt);
	            }
	            private void typesCarburantsTableMouseClicked(java.awt.event.MouseEvent evt) {
	            	int c = VehiculesTable.getSelectedRow();
	            	TableModel model = VehiculesTable.getModel();
	            	
	            	idItemSelected = Integer.parseInt(model.getValueAt(c, 0).toString());
	            	NumeroField.setText(model.getValueAt(c, 1).toString());
	            	ModelField.setText(model.getValueAt(c, 2).toString());
	            	MarqueField.setText(model.getValueAt(c, 3).toString());
	            	CapaciteField.setText(model.getValueAt(c, 4).toString());
	            	NombrePlacesField.setText(model.getValueAt(c, 5).toString());
	            	TypeSelect.setSelectedItem(model.getValueAt(c, 6).toString());
	            	CarburantSelect.setSelectedItem(model.getValueAt(c, 7).toString());
	            	
	            	
	            }
	            
	        });

		scrollPane.setViewportView(VehiculesTable);
		
		fetch();
		
		
		
		
		
		
		
	}
}
