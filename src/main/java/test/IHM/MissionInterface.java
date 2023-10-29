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

import test.Mission;
import test.MissionTransaction;
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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class MissionInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField DateDepartField;
	private JTextField DateArriveField;
	private JTextField LongeurField;
	private JTextField ConsomationDeclarerField;
	private JTextField ConsomationAttenduField;
	
	private JTable MissionsTable;
	
	private List<Mission> missions = new ArrayList<Mission>();
	private int idItemSelected;
	private JTextField NumeroField;



	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MissionInterface frame = new MissionInterface();
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
    	DateDepartField.setText("");
    	DateArriveField.setText("");
    	LongeurField.setText("");
    	ConsomationDeclarerField.setText("");
    	ConsomationAttenduField.setText("");
    	NumeroField.setText("");
    }
    
    
    // fonction permet la mise a jour du tableau des Types carburants
    
    
    private void fetch() {
    	missions.clear();
    	try {
			MissionTransaction MT = new MissionTransaction();
			missions = MT.getAll();
			if(missions != null) {
			DefaultTableModel model = (DefaultTableModel) MissionsTable.getModel();
            for (Mission item : missions) {

                Object[] row = new Object[9];
                row[0] = item.getId();
                row[1] = item.getNumero();
                row[2] = item.getDateDepart();
                row[3] = item.getDateArrive();
                row[4] = item.getLongeurTrajet();
                row[5] = item.getConsomationDeclare();
                row[6] = item.getConsomationAttendu();
                row[7] = item.getIdChauffeur();
                row[8] = item.getIdVehicule();

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
	public MissionInterface() {
		
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
		mission.setLayout(null);
		
		JPanel Create = new JPanel();
		Create.setBounds(0, 0, 300, 600);
		mission.add(Create);
		Create.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DateDépart");
		lblNewLabel.setBounds(10, 60, 100, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		Create.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("DateArrivé");
		lblNewLabel_1.setBounds(10, 100, 100, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		Create.add(lblNewLabel_1);

		
		
		JLabel lblNewLabel_2 = new JLabel("LongeurTrajet");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 140, 100, 25);
		Create.add(lblNewLabel_2);

		
		JLabel lblNewLabel_2_1 = new JLabel("ConsomationDeclar\u00E9");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 180, 150, 25);
		Create.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ConsomationAttendu");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 220, 150, 25);
		Create.add(lblNewLabel_2_1_1);
		

		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Chauffeur");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 260, 150, 25);
		Create.add(lblNewLabel_2_1_1_1);
		

		JLabel Se = new JLabel("V\u00E9hicule");
		Se.setFont(new Font("Arial", Font.PLAIN, 16));
		Se.setBounds(10, 300, 150, 25);
		Create.add(Se);
		
		
		DateDepartField = new JTextField();
		DateDepartField.setBounds(170, 60, 120, 25);
		Create.add(DateDepartField);
		DateDepartField.setColumns(10);
		
		DateArriveField = new JTextField();
		DateArriveField.setColumns(10);
		DateArriveField.setBounds(170, 100, 120, 25);
		Create.add(DateArriveField);
		
		LongeurField = new JTextField();
		LongeurField.setColumns(10);
		LongeurField.setBounds(170, 140, 120, 25);
		Create.add(LongeurField);
		
		ConsomationDeclarerField = new JTextField();
		ConsomationDeclarerField.setColumns(10);
		ConsomationDeclarerField.setBounds(170, 180, 120, 25);
		Create.add(ConsomationDeclarerField);
		
		ConsomationAttenduField = new JTextField();
		ConsomationAttenduField.setColumns(10);
		ConsomationAttenduField.setBounds(170, 220, 120, 25);
		Create.add(ConsomationAttenduField);	
		
		
		// charger tous les types du carburant dans le menu select dans l'insersion du vehicule :
				UserTransaction UT = null;
				List<User> user = new ArrayList<User>();
				try {
					UT = new UserTransaction();
					user = UT.getAll("CHAUFFEUR");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String[] u = new String[user.size()];
				
				for(int i = 0; i < user.size(); i++) {
					u[i] = user.get(i).getCode();
				}
				
		
				@SuppressWarnings({ "rawtypes", "unchecked" })
				
				final JComboBox ChauffeurSelect = new JComboBox(u);
				ChauffeurSelect.setBounds(170, 260, 120, 25);
				Create.add(ChauffeurSelect);
		
			
				VehiculeTransaction VT1 = null;
				List<Vehicule> v = new ArrayList<Vehicule>();
				try {
					VT1 = new VehiculeTransaction();
					 v = VT1.getAll();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String[] sv = new String[v.size()];

				for(int i = 0; i < v.size(); i++) {
					sv[i] = v.get(i).getNumero();
				}
				
				
				
				
				@SuppressWarnings({ "rawtypes", "unchecked" })
				final JComboBox VehiculeSelect = new JComboBox(sv);
				VehiculeSelect.setBounds(170, 300, 120, 25);
				Create.add(VehiculeSelect);

				
				
				
		
		// Buttons et leurs actions :
		
		JButton ButtonAjouter = new JButton("Ajouter");
		ButtonAjouter.setBounds(10, 400, 85, 21);
		ButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
            
            private void btnAjouterActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
            	String numero = NumeroField.getText().trim();
            	
            	
            	
            	
            	Date dateDepart = Date.valueOf(DateDepartField.getText().toString());
            	Date dateArrive = Date.valueOf(DateArriveField.getText().toString());

                String Longeur = LongeurField.getText().trim();
                String consomationDeclarer = ConsomationDeclarerField.getText().trim();
                String consomationAttendu = ConsomationAttenduField.getText().trim();
                String chauffeur = ChauffeurSelect.getSelectedItem().toString();
                String vehicule = VehiculeSelect.getSelectedItem().toString(); 

                
                
                
                
                if(!(DateDepartField.getText().toString()).isEmpty() && !(DateArriveField.getText().toString()).isEmpty() && !Longeur.isEmpty() && !consomationDeclarer.isEmpty() && !consomationAttendu.isEmpty() && !chauffeur.isEmpty() && !vehicule.isEmpty() ) {
                	
                	try {
                		
						MissionTransaction MT = new MissionTransaction();
						VehiculeTransaction VT = new VehiculeTransaction();
						UserTransaction UT = new UserTransaction();
						
						Mission m = MT.getByNumero(numero);
						
						if(m == null) {

							MT.save(new Mission(numero, dateDepart, dateArrive, Longeur, consomationDeclarer, consomationAttendu, UT.getByCode(chauffeur).getId(), VT.getByNumero(vehicule).getId()));
							 DefaultTableModel model1 = (DefaultTableModel) MissionsTable.getModel();
			                    Object[] row = new Object[9];
			                    row[0] = MT.getByNumero(numero).getId();
			                    row[1] = numero;
			                    row[2] = dateDepart;
			                    row[3] = dateArrive;
			                    row[4] = Longeur;
			                    row[5] = consomationDeclarer;
			                    row[6] = consomationAttendu;
			                    row[7] = chauffeur;
			                    row[8] = vehicule;
			                    
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
		ButtonModifier.setBounds(110, 400, 85, 21);
		ButtonModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnModifierActionPerformed(evt);
			}
			
			private void btnModifierActionPerformed(ActionEvent evt) {
				
				String numero = NumeroField.getText().trim();
				
				Date dateDepart = Date.valueOf(DateDepartField.getText().toString());
            	Date dateArrive = Date.valueOf(DateArriveField.getText().toString());
				
                String Longeur = LongeurField.getText().trim();
                String consomationDeclarer = ConsomationDeclarerField.getText().trim();
                String consomationAttendu = ConsomationAttenduField.getText().trim();
                String chauffeur = ChauffeurSelect.getSelectedItem().toString();
                String vehicule = VehiculeSelect.getSelectedItem().toString(); 
                
                if(!(DateDepartField.getText().toString()).isEmpty() && !(DateArriveField.getText().toString()).isEmpty() && !Longeur.isEmpty() && !consomationDeclarer.isEmpty() && !consomationAttendu.isEmpty() && !chauffeur.isEmpty() && !vehicule.isEmpty() ) {
                	
                	try {
                		MissionTransaction MT = new MissionTransaction();
                		VehiculeTransaction VT = new VehiculeTransaction();
                		UserTransaction UT = new UserTransaction();
                		
						Mission m = MT.getById(idItemSelected);
						if(m != null) {

							MT.update(new Mission(numero, dateDepart, dateArrive, Longeur, consomationDeclarer, consomationAttendu, UT.getByCode(chauffeur).getId(), VT.getByNumero(vehicule).getId()), idItemSelected);
							DefaultTableModel model1 = (DefaultTableModel) MissionsTable.getModel();
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
		ButtonSupprimer.setBounds(210, 400, 85, 21);
		ButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
            
            private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
            	int Nrow = MissionsTable.getSelectedRow();
            	if (Nrow >= 0) {
                    int option = JOptionPane.showConfirmDialog(rootPane,
                            "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == 0) {
                    	
                    	 TableModel model = MissionsTable.getModel();

                         String numero = model.getValueAt(Nrow, 1).toString();
                        
                       
                        if (MissionsTable.getSelectedRows().length == 1) {
 	
                        	try {
                        		MissionTransaction MT = new MissionTransaction();
                        		
                        	            		 
                        		MT.delete(MT.getByNumero(numero).getId());
                        		clear();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

                            DefaultTableModel model1 = (DefaultTableModel) MissionsTable.getModel();
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
		
		NumeroField = new JTextField();
		NumeroField.setColumns(10);
		NumeroField.setBounds(170, 20, 120, 25);
		Create.add(NumeroField);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNumero.setBounds(10, 20, 100, 25);
		Create.add(lblNumero);
		
		

		
	
		JPanel Display = new JPanel();
		Display.setBounds(300, 0, 600, 600);
		mission.add(Display);
		Display.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 600);
		Display.add(scrollPane);

		
		// Tableau d'affichage des Types de carburants : 
		MissionsTable = new JTable();
		MissionsTable.setBounds(100, 50, 400, 500);
		MissionsTable.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	            		"id", "numero", "dateDepart", "dateArrive", "longeurTrajet", "ConsDeclare", "ConsAttendu", "idChauffeur", "idVehicule" 	 	
	            }
	        ) {
	            /**
				 * 
				 */
				boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false, false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
				MissionsTable.setCellSelectionEnabled(true);
				MissionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	typesCarburantsTableMouseClicked(evt);
	            }
	            private void typesCarburantsTableMouseClicked(java.awt.event.MouseEvent evt) {
	            	int c = MissionsTable.getSelectedRow();
	            	TableModel model = MissionsTable.getModel();
	            	
	            	idItemSelected = Integer.parseInt(model.getValueAt(c, 0).toString());
	            	NumeroField.setText(model.getValueAt(c, 1).toString());
	            	DateDepartField.setText(model.getValueAt(c, 2).toString());
	            	DateArriveField.setText(model.getValueAt(c, 3).toString());
	            	LongeurField.setText(model.getValueAt(c, 4).toString());
	            	ConsomationDeclarerField.setText(model.getValueAt(c, 5).toString());
	            	ConsomationAttenduField.setText(model.getValueAt(c, 6).toString());
	            	ChauffeurSelect.setSelectedItem(model.getValueAt(c, 7).toString());
	            	VehiculeSelect.setSelectedItem(model.getValueAt(c, 8).toString());
	            	
	            	
	            }
	            
	        });

		scrollPane.setViewportView(MissionsTable);
		
		fetch();
		
		
		
		
		
		
		
	}
	}

