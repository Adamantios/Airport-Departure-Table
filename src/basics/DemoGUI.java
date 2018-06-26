package basics;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;


public class DemoGUI extends javax.swing.JFrame {

    private final MessageBoard thePanel;
    private final DateFormat dateFormatter;

    public DemoGUI() {
        initComponents();

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Utilities.setCurrentDateTime(new Date());
        Utilities.setTimeMultiplier(1);

        DBfunctions.readAllFromDB();

        fillAirlinesTextPanel();
        fillFlightsTextPanel();

        thePanel = new MessageBoard();
        thePanel.setVisible(true);

        TimeWrapper.StartUp();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        ClockSwitch = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        timeMultiplier = new javax.swing.JTextField();
        BtnTimeMultiplierChange = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        newDateTime = new javax.swing.JTextField();
        BtnDateChange = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextAreaAirlines = new javax.swing.JTextArea();
        TextFieldNewAirLineName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAddNewAirline = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAreaFlights = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        fldFid = new javax.swing.JTextField();
        btnGetFlight = new javax.swing.JButton();
        btnCancelFlight = new javax.swing.JButton();
        btnDelayFlight = new javax.swing.JButton();
        fldNewDep = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboAirLine = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        fldDest = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fldFlName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fldVia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fldDep = new javax.swing.JTextField();
        btnSaveFlight = new javax.swing.JButton();
        btnCancelFlightChanges = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Charokopeio University of Athens - Flights Management System");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        Header.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        Header.setForeground(new java.awt.Color(255, 255, 255));
        Header.setText("International Airport of Athens, Eleftherios Venizelos - Flights Management System");
        Header.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Header)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Header.getAccessibleContext().setAccessibleName("HeaderText");

        ClockSwitch.setText("Enable Clock");
        ClockSwitch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ClockSwitchStateChanged(evt);
            }
        });

        jLabel2.setText("Time multiplier");

        timeMultiplier.setText("1");

        BtnTimeMultiplierChange.setText("set");
        BtnTimeMultiplierChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTimeMultiplierChangeActionPerformed(evt);
            }
        });

        jLabel3.setText("Date & time (dd/MM/yyyy HH:mm)");

        BtnDateChange.setText("set");
        BtnDateChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDateChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(ClockSwitch))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(57, 57, 57)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(newDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(timeMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BtnTimeMultiplierChange)
                                                        .addComponent(BtnDateChange))
                                                .addGap(0, 651, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ClockSwitch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(timeMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnTimeMultiplierChange))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(newDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnDateChange))
                                .addContainerGap(386, Short.MAX_VALUE))
        );

        jLabel3.getAccessibleContext().setAccessibleName("Date & time (dd/MM/yyyy HH:mm)");

        jTabbedPane1.addTab("Parameters", jPanel4);

        TextAreaAirlines.setColumns(20);
        TextAreaAirlines.setRows(5);
        jScrollPane2.setViewportView(TextAreaAirlines);

        jLabel1.setText("New Arline name:");

        btnAddNewAirline.setLabel("add");
        btnAddNewAirline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewAirlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TextFieldNewAirLineName, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAddNewAirline)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TextFieldNewAirLineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(btnAddNewAirline))
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Airlines", jPanel2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 331, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 212, Short.MAX_VALUE)
        );

        TextAreaFlights.setColumns(20);
        TextAreaFlights.setRows(5);
        jScrollPane3.setViewportView(TextAreaFlights);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel4.setText("Flight ID for Change");

        btnGetFlight.setText("Get Flight");
        btnGetFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetFlightActionPerformed(evt);
            }
        });

        btnCancelFlight.setText("Cancel Flight");
        btnCancelFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFlightActionPerformed(evt);
            }
        });

        btnDelayFlight.setText("Delay Flight");
        btnDelayFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelayFlightActionPerformed(evt);
            }
        });

        jLabel13.setText("(dd/MM/yyyy HH:mm)");

        jLabel14.setText("New Departure");

        jLabel5.setText("Airline");

        comboAirLine.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jLabel10.setText("Destination");

        jLabel8.setText("Flight Name");

        jLabel15.setText("(dd/MM/yyyy HH:mm)");

        jLabel12.setText("Via");

        fldVia.setToolTipText("");

        jLabel6.setText("Departure");

        btnSaveFlight.setText("Save Flight");
        btnSaveFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFlightActionPerformed(evt);
            }
        });

        btnCancelFlightChanges.setText("Cancel Changes");
        btnCancelFlightChanges.setActionCommand("Cancel");
        btnCancelFlightChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelFlightChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fldFid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnGetFlight))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(fldVia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(fldDest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(comboAirLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(btnSaveFlight)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnCancelFlightChanges)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnCancelFlight)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel6))
                                                .addGap(9, 9, 9)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(btnDelayFlight)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fldNewDep, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(fldFlName)
                                                        .addComponent(fldDep, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(btnCancelFlight)
                                                                .addComponent(btnDelayFlight)
                                                                .addComponent(fldNewDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(fldFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnGetFlight)
                                                                .addComponent(jLabel4))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel13)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel14)))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(comboAirLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(fldDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel10))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(fldVia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel12)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(fldFlName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel15))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(fldDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6))))
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSaveFlight)
                                                        .addComponent(btnCancelFlightChanges)))))
        );

        jTabbedPane1.addTab("Flights", jPanel3);

        btnEnd.setText("Save all Airlines & Flights to DB & Exit");
        btnEnd.setActionCommand("Save Airlines & Flights to DB & Exit");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnEnd)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEnd)
                                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("tabs");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillAirlinesTextPanel() {
        // also fill the drop down list in the flights tab
        comboAirLine.removeAllItems();

        if (!AirLines.getAllAirlines().isEmpty()) {
            StringBuilder s = new StringBuilder();
            for (Airline a : AirLines.getAllAirlines()) {
                s.append(a.getSaID()).append("\t").append(a.getAirlineName()).append("\n");
                comboAirLine.addItem(a.getAirlineName());
            }
            TextAreaAirlines.setText(s.toString());
        }
    }

    private String FlightToText(Flight f) {
        DateFormat df = new SimpleDateFormat("dd/MM HH:mm");

        String s = "";
        s += f.getSfID() + "\t";
        s += f.getFlightName() + "\t";
        s += f.getAirline() + "\t";
        s += f.getDestination() + "\t";
        s += f.getVia() + "\t";
        s += df.format(f.getScheduledDepartureDateTime()) + "\t";
        s += df.format(f.getExpectedDepartureDateTime()) + "\t";
        s += f.getCancelDate() == null ? "" : df.format(f.getCancelDate());
        s += "\t" + f.getStrState();

        return s;
    }

    private void fillFlightsTextPanel() {
        StringBuilder s = new StringBuilder("ID\tName\tAirline\tDestination\tVia\tScheduled\tExpected\tCanceled\tInitial State");
        ArrayList<Flight> allFlights = new ArrayList<>();
        for (Airline a : AirLines.getAllAirlines()) {
            for (String key : a.getMyFlights().keySet()) {
                allFlights.add(a.getMyFlights().get(key));
            }
        }

        allFlights.sort(new FlightComparator());

        for (Flight f : allFlights) {
            s.append("\n").append(FlightToText(f));
        }

        TextAreaFlights.setText(s.toString());
    }

    private void ClockSwitchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ClockSwitchStateChanged
        if (ClockSwitch.isSelected()) {
            TimeWrapper.Start();
        } else {
            TimeWrapper.Suspend();
        }
    }//GEN-LAST:event_ClockSwitchStateChanged

    private void BtnDateChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDateChangeActionPerformed
        Date userDate;

        if (newDateTime.getText().isEmpty()) {
            showMessageDialog(null, "Please insert a date - time!");
            return;
        }

        try {
            userDate = dateFormatter.parse(newDateTime.getText());
        } catch (ParseException ex) {
            showMessageDialog(null, "Please insert a correct date - time in a correct format!");
            return;
        }

        Utilities.setCurrentDateTime(userDate);
    }//GEN-LAST:event_BtnDateChangeActionPerformed

    private void BtnTimeMultiplierChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTimeMultiplierChangeActionPerformed

        int i = Utilities.getTimeMultiplier();

        try {
            i = Integer.parseInt(timeMultiplier.getText());
            if (i < 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            timeMultiplier.setText(Integer.toString(i));
            showMessageDialog(null, "Please insert a positive integer value!");
            return;
        }

        Utilities.setTimeMultiplier(i);
    }//GEN-LAST:event_BtnTimeMultiplierChangeActionPerformed

    private void btnAddNewAirlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewAirlineActionPerformed
        if (AirLines.airlineExists(TextFieldNewAirLineName.getText())) {
            showMessageDialog(null, "Airline already exists!");
            return;
        }
        Airline a = new Airline(TextFieldNewAirLineName.getText());
        AirLines.addAirline(a);
        fillAirlinesTextPanel();
    }//GEN-LAST:event_btnAddNewAirlineActionPerformed

    private void btnGetFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetFlightActionPerformed
        Flight f = AirLines.getFlight(fldFid.getText());
        if (f == null) {
            showMessageDialog(null, "Flight does not exist!");
            return;
        }

        fldFid.setEnabled(false);

        fldFlName.setText(f.getFlightName());
        fldDep.setText(dateFormatter.format(f.getExpectedDepartureDateTime()));
        fldDest.setText(f.getDestination());
        fldVia.setText(f.getVia());
    }//GEN-LAST:event_btnGetFlightActionPerformed

    private void btnCancelFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFlightActionPerformed
        Flight f = AirLines.getFlight(fldFid.getText());
        if (f == null) {
            showMessageDialog(null, "Flight does not exist!");
            return;
        }

        if (f.getState().equals(Flight.FlightState.Cancelled)) {
            showMessageDialog(null, "Flight is already Canceled!");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Do you want to change the state of the Flight"
                        + f.getFlightName()
                        + " of " + f.getAirline()
                        + " to CANCELED ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            f.cancel();
            f.setCancelDate(Utilities.getCurrentDateTime());
        } catch (Exception ex) {
            showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnCancelFlightActionPerformed

    private void btnDelayFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelayFlightActionPerformed
        Flight f = AirLines.getFlight(fldFid.getText());
        if (f == null) {
            showMessageDialog(null, "Flight does not exist!");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Do you want to DELAY the Flight"
                        + f.getFlightName()
                        + " of " + f.getAirline()
                        + " ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }

        Date userDate;
        try {
            userDate = dateFormatter.parse(fldNewDep.getText());
        } catch (ParseException ex) {
            showMessageDialog(null, "Please insert a correct date - time in a correct format!");
            return;
        }

        if (Utilities.offDuty(userDate)) {
            showMessageDialog(null, "No flights are being conducted from 1:00 to 5:00! Please insert another time.");
            return;
        }

        if (Utilities.timeCannotBeUsed(userDate)) {
            showMessageDialog(null, "The time slot is in use! Please insert another one.");
            return;
        }

        try {
            f.delay(userDate);
        } catch (Exception ex) {
            showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnDelayFlightActionPerformed

    private void btnSaveFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFlightActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Do you want to save ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }

        Date userDate;
        try {
            userDate = dateFormatter.parse(fldDep.getText());
        } catch (ParseException ex) {
            showMessageDialog(null, "Please insert a correct date - time in a correct format!");
            return;
        }

        if (Utilities.offDuty(userDate)) {
            showMessageDialog(null, "No flights are being conducted from 1:00 to 5:00! Please insert another time.");
            return;
        }

        if (Utilities.timeCannotBeUsed(userDate)) {
            showMessageDialog(null, "The time slot is in use! Please insert another one.");
            return;
        }

        if ("".equals(fldFid.getText())) {
            try {
                Flight f = new Flight(fldDest.getText(), fldFlName.getText(),
                        fldVia.getText(), userDate, Objects.requireNonNull(comboAirLine.getSelectedItem()).toString());
                f.setfID(f.getNewFlightID());

                AirLines.getAirline(f.getAirline()).addFlight(f);

                TextAreaFlights.append("\n" + FlightToText(f));
            } catch (Exception ignored) {
            }
        } else {
            Flight f = AirLines.getFlight(fldFid.getText());
            if (f != null) {
                f.setDestination(fldDest.getText());
                f.setFlightName(fldFlName.getText());
                f.setVia(fldVia.getText());
                f.setScheduledDepartureDateTime(userDate);

                if (!f.getAirline().equals(Objects.requireNonNull(comboAirLine.getSelectedItem()).toString())) {
                    AirLines.getAirline(f.getAirline()).removeFlight(f);
                    f.setAirline(comboAirLine.getSelectedItem().toString());
                    AirLines.getAirline(f.getAirline()).addFlight(f);
                }
            }
        }

        fldFid.setEnabled(true);
        fldFid.setText("");
        fldFlName.setText("");
        fldDep.setText("");
        fldDest.setText("");
        fldVia.setText("");

        fillFlightsTextPanel();
    }//GEN-LAST:event_btnSaveFlightActionPerformed

    private void btnCancelFlightChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelFlightChangesActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Do you want to discard all data?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            return;
        }
        fldFid.setEnabled(true);
        fldFid.setText("");
        fldFlName.setText("");
        fldDep.setText("");
        fldDest.setText("");
        fldVia.setText("");
    }//GEN-LAST:event_btnCancelFlightChangesActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        DBfunctions.saveAllToDB();
        TimeWrapper.ShutDown();
        thePanel.setVisible(false);
        thePanel.dispose();
        this.dispose();
    }//GEN-LAST:event_btnEndActionPerformed

    public static void main(String args[]) throws SQLException, InterruptedException, ParseException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DemoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDateChange;
    private javax.swing.JButton BtnTimeMultiplierChange;
    private javax.swing.JCheckBox ClockSwitch;
    private static javax.swing.JLabel Header;
    private javax.swing.JTextArea TextAreaAirlines;
    private javax.swing.JTextArea TextAreaFlights;
    private javax.swing.JTextField TextFieldNewAirLineName;
    private javax.swing.JButton btnAddNewAirline;
    private javax.swing.JButton btnCancelFlight;
    private javax.swing.JButton btnCancelFlightChanges;
    private javax.swing.JButton btnDelayFlight;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnGetFlight;
    private javax.swing.JButton btnSaveFlight;
    private javax.swing.JComboBox comboAirLine;
    private javax.swing.JTextField fldDep;
    private javax.swing.JTextField fldDest;
    private javax.swing.JTextField fldFid;
    private javax.swing.JTextField fldFlName;
    private javax.swing.JTextField fldNewDep;
    private javax.swing.JTextField fldVia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField newDateTime;
    private javax.swing.JTextField timeMultiplier;
    // End of variables declaration//GEN-END:variables

}
