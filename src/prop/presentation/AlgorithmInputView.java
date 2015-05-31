package prop.presentation;

import prop.ErrorString;
import prop.PropException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;

public class AlgorithmInputView extends JPanel {

    private SongPController songPController;
    private UserPController userPController;
    private ListPController listPController;
    private AlgorithmPController algorithmPController;
    private ArrayList<String> simpleRelations;
    private ArrayList<String> complexRelations;
    private DefaultListModel simpleRelationsModel;
    private DefaultListModel complexRelationsModel;
    private AlgorithmTabView algorithmTabView;

    public AlgorithmInputView(SongPController spc, UserPController upc, AlgorithmPController apc, ListPController lpc, AlgorithmTabView atv) {
        songPController = spc;
        userPController = upc;
        algorithmPController = apc;
        listPController = lpc;
        algorithmTabView = atv;
        simpleRelations = new ArrayList<>();
        complexRelations = new ArrayList<>();
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        simpleRelationsList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        addSimpleRelationButton = new javax.swing.JButton();
        addComplexRelationButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        complexRelationsList = new javax.swing.JList();
        executeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        removeSimpleRelationButton = new javax.swing.JButton();
        removeComplexRelationButton = new javax.swing.JButton();
        algorithmComboBox = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSpinner2 = new javax.swing.JSpinner();
        jTextField3 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        listTitleField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numberOfCommunities = new javax.swing.JSpinner();

        jSpinner2.setVisible(false);
        jComboBox3.setVisible(false);

        simpleRelationsModel = new DefaultListModel();
        simpleRelationsList.setModel(simpleRelationsModel);

        complexRelationsModel = new DefaultListModel();
        complexRelationsList.setModel(complexRelationsModel);

        SpinnerNumberModel communitiesModel = new SpinnerNumberModel(1,1,999999,1);
        numberOfCommunities = new javax.swing.JSpinner(communitiesModel);

        jLabel1.setText("Algorithm Input");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Song title", "Song artist", "Song album",
                "Song year", "Song genre", "Song subgenre", "Song duration", "User name", "User age", "User gender"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("New simple relation");


        jScrollPane1.setViewportView(simpleRelationsList);

        jLabel3.setText("New complex relation");

        addSimpleRelationButton.setText("Add");
        addSimpleRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addComplexRelationButton.setText("Add");
        addComplexRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });


        jScrollPane2.setViewportView(complexRelationsList);

        executeButton.setText("Execute");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel4.setText("Ex: ((0|1)&!2)");

        jLabel5.setText("Select algorithm");

        removeSimpleRelationButton.setText("Remove");
        removeSimpleRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        removeComplexRelationButton.setText("Remove");
        removeComplexRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("List title");

        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Girvan-Newman", "Louvain", "Clique Percolation Method"}));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setText("List title");

        errorLabel.setText("Error");
        errorLabel.setVisible(false);
        errorLabel.setForeground(Color.red);

        jLabel8.setText("Communities");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jSeparator3)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addComplexRelationButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(removeComplexRelationButton))
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(addSimpleRelationButton)
                                                                .addGap(10, 10, 10)
                                                                .addComponent(removeSimpleRelationButton))
                                                        .addComponent(jComboBox1, 0, 347, Short.MAX_VALUE)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(19, 19, 19)
                                                .addComponent(jScrollPane1))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(executeButton)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(algorithmComboBox, 0, 204, Short.MAX_VALUE)
                                                                        .addComponent(listTitleField))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(320, 320, 320)
                                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(370, 370, 370)
                                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addComponent(numberOfCommunities, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(addSimpleRelationButton)
                                                        .addComponent(removeSimpleRelationButton))
                                                .addGap(39, 39, 39)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(addComplexRelationButton)
                                                                        .addComponent(removeComplexRelationButton)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(26, 26, 26)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5)
                                                                .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(listTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(numberOfCommunities, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addComponent(executeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = jComboBox1.getSelectedIndex();
        String s;
        if (i == 0) s = "song_title|" + jTextField3.getText().trim();
        else if (i == 1) s = "song_artist|" + jTextField3.getText().trim();
        else if (i == 2) s = "song_album|" + jTextField3.getText().trim();
        else if (i == 3) s = "song_year|" + jSpinner2.getValue().toString();
        else if (i == 4) s = "song_genre|" + jComboBox3.getSelectedIndex();
        else if (i == 5) s = "song_subgenre|" + jComboBox3.getSelectedIndex();
        else if (i == 6) s = "song_duration|" + jSpinner2.getValue().toString();
        else if (i == 7) s = "user_name|" + jTextField3.getText().trim();
        else if (i == 8) s = "user_age|" + jSpinner2.getValue().toString();
        else {
            s = "user_gender|";
            if (jComboBox3.getSelectedIndex() == 0) s += "FEMALE";
            else if (jComboBox3.getSelectedIndex() == 1) s += "MALE";
            else s += "OTHER";
        }
        simpleRelations.add(s);
        updateSimpleRelationListModel();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String s = jTextField2.getText().trim();
        complexRelations.add(s);
        updateComplexRelationListModel();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!simpleRelationsList.isSelectionEmpty()) {
            int i = simpleRelationsList.getSelectedIndex();
            simpleRelations.remove(i);
            updateSimpleRelationListModel();
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!complexRelationsList.isSelectionEmpty()) {
            int i = complexRelationsList.getSelectedIndex();
            complexRelations.remove(i);
            updateComplexRelationListModel();
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        algorithmPController.initGraph();
        String[] simpRel = new String[simpleRelations.size()];
        simpRel = simpleRelations.toArray(simpRel);
        for (String s : complexRelations) {
            try {
                algorithmPController.addRelation(simpRel,s,simpleRelations.size());
            } catch (PropException e) {
                errorLabel.setText(e.getMessage());
                errorLabel.setVisible(true);
                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        errorLabel.setVisible(false);
                    }
                };
                Timer timer = new Timer(3000, listener);
                timer.start();
            }
        }
        try {
            double start = getCpuTime();
            algorithmPController.execute(listTitleField.getText().trim(), algorithmComboBox.getSelectedIndex(), (Integer) numberOfCommunities.getValue(), listPController.getListController(), algorithmPController.getRelationController());
            double time = (getCpuTime() - start) / 1e9;
            System.out.println("Execution time: " + time + " s");
            algorithmTabView.setOutputPanel(listTitleField.getText().trim());
        } catch (PropException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    errorLabel.setVisible(false);
                }
            };
            Timer timer = new Timer(3000, listener);
            timer.start();
        }
    }

    private double getCpuTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadCpuTime( ) : 0L;
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox1.getSelectedIndex() == 0 ||
                jComboBox1.getSelectedIndex() == 1 ||
                jComboBox1.getSelectedIndex() == 2 ||
                jComboBox1.getSelectedIndex() == 7) {
            jTextField3.setVisible(true);
            jComboBox3.setVisible(false);
            jSpinner2.setVisible(false);
        }
        else if (jComboBox1.getSelectedIndex() == 4 ||
                jComboBox1.getSelectedIndex() == 5 ||
                jComboBox1.getSelectedIndex() == 9) {
            jTextField3.setVisible(false);
            jComboBox3.setVisible(true);
            jSpinner2.setVisible(false);
            if (jComboBox1.getSelectedIndex() == 9) {
                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(userPController.getGenres()));
            } else {
                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(songPController.listGenres()));
            }
        }
        else {
            jTextField3.setVisible(false);
            jComboBox3.setVisible(false);
            jSpinner2.setVisible(true);
        }
    }


    public void updateSimpleRelationListModel() {
        simpleRelationsModel.clear();
        int i;
        for (i = 0; i < simpleRelations.size(); ++i) {
            simpleRelationsModel.addElement("(" + i + ")" + " " + simpleRelations.get(i));
        }
    }

    public void updateComplexRelationListModel() {
        complexRelationsModel.clear();
        int i;
        for (i = 0; i < complexRelations.size(); ++i) {
            complexRelationsModel.addElement(complexRelations.get(i));
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addSimpleRelationButton;
    private javax.swing.JButton addComplexRelationButton;
    private javax.swing.JButton executeButton;
    private javax.swing.JButton removeSimpleRelationButton;
    private javax.swing.JButton removeComplexRelationButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox algorithmComboBox;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList simpleRelationsList;
    private javax.swing.JList complexRelationsList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField listTitleField;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSpinner numberOfCommunities;
    // End of variables declaration
}