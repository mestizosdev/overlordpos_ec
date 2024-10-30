/*
 * Copyright (C) 2023 Jorge Luis
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package dev.joguenco.pos.holiday;

import com.unicenta.basic.BasicException;
import com.unicenta.pos.forms.AppLocal;
import com.unicenta.pos.forms.AppView;
import com.unicenta.pos.forms.BeanFactoryApp;
import com.unicenta.pos.forms.BeanFactoryException;
import com.unicenta.pos.forms.JPanelView;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Jorge Luis
 */
@Slf4j
public class Holiday extends JPanel implements JPanelView, BeanFactoryApp {

    private AppView app;
    private DataLogicHoliday dlHoliday;
    private final String dateFormat = "yyyy-MM-dd";

    public Holiday() {
        initComponents();
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Holiday");
    }

    @Override
    public void activate() throws BasicException {
        loadData();
        lookTable(tableHoliday);
    }

    private void loadData() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        txtYear.setText(String.valueOf(calendar.get(Calendar.YEAR)));

        lstMonth.removeAllItems();
        lstMonth.addItem("1");
        lstMonth.addItem("2");
        lstMonth.addItem("3");
        lstMonth.addItem("4");
        lstMonth.addItem("5");
        lstMonth.addItem("6");
        lstMonth.addItem("7");
        lstMonth.addItem("8");
        lstMonth.addItem("9");
        lstMonth.addItem("10");
        lstMonth.addItem("11");
        lstMonth.addItem("12");
        lstMonth.addItem("Todos");

        lstMonth.setSelectedIndex(calendar.get(Calendar.MONTH));
        loadDataTable();
    }

    private void loadDataTable() {
        try {
            List<HolidayInfo> holiday = null;

            if ("Todos".equals(lstMonth.getSelectedItem().toString())) {
                holiday = dlHoliday.listHolidays(
                        txtYear.getText()
                );
            } else {
                holiday = dlHoliday.listHolidays(
                        txtYear.getText(),
                        lstMonth.getSelectedItem().toString()
                );
            }

            DefaultTableModel model = (DefaultTableModel) tableHoliday.getModel();
            model.setRowCount(0);

            for (var i : holiday) {
                var formatter = new SimpleDateFormat(dateFormat);

                String[] row = {
                    i.getId().toString(),
                    i.getName(),
                    formatter.format(i.getDate())
                };

                model.addRow(row);
            }
        } catch (BasicException ex) {
            log.error(Holiday.class.getName() + " " + ex.getMessage());
        }
    }

    @Override
    public boolean deactivate() {
        return true;
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public void init(AppView app) throws BeanFactoryException {
        this.app = app;
        dlHoliday = (DataLogicHoliday) this.app.getBean("dev.joguenco.pos.holiday.DataLogicHoliday");
    }

    @Override
    public Object getBean() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        year_month = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lstMonth = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmdSearch = new javax.swing.JButton();
        holidays = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoliday = new javax.swing.JTable();
        cmdAdd = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        year_month.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Año:");

        txtYear.setMinimumSize(new java.awt.Dimension(120, 45));
        txtYear.setPreferredSize(new java.awt.Dimension(120, 45));

        jLabel2.setText("Mes:");

        cmdSearch.setText("Buscar");
        cmdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout year_monthLayout = new javax.swing.GroupLayout(year_month);
        year_month.setLayout(year_monthLayout);
        year_monthLayout.setHorizontalGroup(
            year_monthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(year_monthLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lstMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        year_monthLayout.setVerticalGroup(
            year_monthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(year_monthLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(year_monthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cmdSearch))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        holidays.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableHoliday.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableHoliday.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHoliday);

        cmdAdd.setText("Añadir");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });

        cmdDelete.setText("Borrar");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout holidaysLayout = new javax.swing.GroupLayout(holidays);
        holidays.setLayout(holidaysLayout);
        holidaysLayout.setHorizontalGroup(
            holidaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holidaysLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(holidaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAdd)
                    .addComponent(cmdDelete))
                .addContainerGap())
        );
        holidaysLayout.setVerticalGroup(
            holidaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holidaysLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(holidaysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(holidaysLayout.createSequentialGroup()
                        .addComponent(cmdAdd)
                        .addGap(18, 18, 18)
                        .addComponent(cmdDelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Revisar las variables de sistema: Tax.Holidays y Tax.Normal.Days");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(holidays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(year_month, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(year_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(holidays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSearchActionPerformed

        loadDataTable();
    }//GEN-LAST:event_cmdSearchActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        if ("Todos".equals(lstMonth.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(this, "Se debe escojer un mes para añadir un día festivo",
                    "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogHoliday dialog = new DialogHoliday(
                        new javax.swing.JFrame(),
                        true,
                        app,
                        txtYear.getText(),
                        lstMonth.getSelectedItem().toString());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        loadDataTable();
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Añadir día festivo");
                dialog.setVisible(true);
            }
        });
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        if (tableHoliday.getSelectedRow() >= 0) {
            if (tableHoliday.getValueAt(
                    tableHoliday.getSelectedRow(), 0) == null) {
                return;
            }

            final var value = tableHoliday.getValueAt(tableHoliday.getSelectedRow(), 0).toString();

            try {
                int response = JOptionPane.showConfirmDialog(this, "Está seguro de borrar?");
                if (response == 0) {
                    dlHoliday.deleteHoliday(value);
                    loadDataTable();
                }
            } catch (BasicException ex) {
                log.error(Holiday.class.getName() + " " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void lookTable(JTable table) {

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        // id
        table.getColumnModel()
                .getColumn(0).setPreferredWidth(90);
        // Name
        table.getColumnModel()
                .getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
        // Date
        table.getColumnModel()
                .getColumn(2).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setCellRenderer(leftRenderer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdSearch;
    private javax.swing.JPanel holidays;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstMonth;
    private javax.swing.JTable tableHoliday;
    private javax.swing.JTextField txtYear;
    private javax.swing.JPanel year_month;
    // End of variables declaration//GEN-END:variables
}