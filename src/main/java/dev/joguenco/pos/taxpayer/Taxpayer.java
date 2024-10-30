//    Mestizo Pos - Touch Friendly Point Of Sale
//    https://mestizos.dev
//
//    Mestizo Pos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Mestizo Pos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Mestizo Pos.  If not, see <http://www.gnu.org/licenses/>.
package dev.joguenco.pos.taxpayer;


import com.unicenta.basic.BasicException;
import com.unicenta.data.loader.TableDefinition;
import com.unicenta.pos.forms.AppLocal;
import com.unicenta.pos.forms.AppView;
import com.unicenta.pos.forms.BeanFactoryApp;
import com.unicenta.pos.forms.BeanFactoryException;
import com.unicenta.pos.forms.JPanelView;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author jorgeluis
 */
@Slf4j
public class Taxpayer extends JPanel implements JPanelView, BeanFactoryApp {

    private AppView app;    
    private DataLogicTaxpayer dlTaxpayer;
    private TableDefinition tdTaxpayer;

    public Taxpayer() {
        initComponents();
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Taxpayer");
    }

    @Override
    public void activate() throws BasicException {
        loadData();
    }

    private void loadData() {
        try {
            TaxpayerInfo taxpayer = (TaxpayerInfo) this.dlTaxpayer.getTaxPayerInfo().find("1");

            txtIdentification.setText(taxpayer.getIdentification());
            txtLegalName.setText(taxpayer.getLegalName());

            if (taxpayer.getForcedAccounting().equals("SI")) {
                chkForcedAccounting.setText("SI");
                chkForcedAccounting.setSelected(true);
            } else {
                chkForcedAccounting.setText("NO");
                chkForcedAccounting.setSelected(false);
            }

            txtSpecialTaxPayer.setText(taxpayer.getSpecialTaxpayer());
            txtRetentionAgent.setText(taxpayer.getRetentionAgent());
            txtOther.setText(taxpayer.getOther());

        } catch (BasicException ex) {
            log.error(ex.getMessage());
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
        this.dlTaxpayer = (DataLogicTaxpayer) this.app.getBean("dev.joguenco.pos.taxpayer.DataLogicTaxpayer");
        this.tdTaxpayer = this.dlTaxpayer.getTableTaxPayer();
    }

    @Override
    public Object getBean() {
        return this;
    }

    private Object createValue() {
        Object[] taxPayer = new Object[7];

        taxPayer[0] = 1;
        taxPayer[1] = txtIdentification.getText();
        taxPayer[2] = txtLegalName.getText();
        taxPayer[3] = chkForcedAccounting.getText();
        taxPayer[4] = txtSpecialTaxPayer.getText().isEmpty() ? null : txtSpecialTaxPayer.getText();
        taxPayer[5] = txtRetentionAgent.getText().isEmpty() ? null : txtRetentionAgent.getText();
        taxPayer[6] = txtOther.getText().isEmpty() ? null : txtOther.getText();

        return taxPayer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelInformation = new javax.swing.JPanel();
        txtIdentification = new javax.swing.JTextField();
        lblIdentification = new javax.swing.JLabel();
        lblLegalName = new javax.swing.JLabel();
        txtLegalName = new javax.swing.JTextField();
        jPanelData = new javax.swing.JPanel();
        lblForcedAccounting = new javax.swing.JLabel();
        chkForcedAccounting = new javax.swing.JCheckBox();
        lblSpecialTaxPayer = new javax.swing.JLabel();
        txtRetentionAgent = new javax.swing.JTextField();
        lblRetentionAgent = new javax.swing.JLabel();
        txtSpecialTaxPayer = new javax.swing.JTextField();
        lblOther = new javax.swing.JLabel();
        txtOther = new javax.swing.JTextField();
        cmdOk = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 510));

        jPanelMain.setName("jPanelMain"); // NOI18N

        jPanelInformation.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIdentification.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblIdentification.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblIdentification.setText("Identificación");

        lblLegalName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblLegalName.setText("Razón Social");

        txtLegalName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelInformationLayout = new javax.swing.GroupLayout(jPanelInformation);
        jPanelInformation.setLayout(jPanelInformationLayout);
        jPanelInformationLayout.setHorizontalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdentification))
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblLegalName))
                    .addGroup(jPanelInformationLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(txtLegalName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanelInformationLayout.setVerticalGroup(
            jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentification)
                    .addComponent(lblLegalName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdentification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLegalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanelData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblForcedAccounting.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblForcedAccounting.setText("Obligado Contabilidad");

        chkForcedAccounting.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chkForcedAccounting.setText("Si / No");
        chkForcedAccounting.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkForcedAccountingStateChanged(evt);
            }
        });

        lblSpecialTaxPayer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSpecialTaxPayer.setText("Contribuyente Especial");

        txtRetentionAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblRetentionAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRetentionAgent.setText("Agente de Retención");

        txtSpecialTaxPayer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblOther.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOther.setText("Otro");

        txtOther.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelDataLayout = new javax.swing.GroupLayout(jPanelData);
        jPanelData.setLayout(jPanelDataLayout);
        jPanelDataLayout.setHorizontalGroup(
            jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOther, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOther)
                    .addComponent(lblForcedAccounting)
                    .addComponent(chkForcedAccounting)
                    .addComponent(lblSpecialTaxPayer)
                    .addComponent(txtSpecialTaxPayer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRetentionAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRetentionAgent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDataLayout.setVerticalGroup(
            jPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblForcedAccounting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkForcedAccounting)
                .addGap(18, 18, 18)
                .addComponent(lblSpecialTaxPayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSpecialTaxPayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRetentionAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRetentionAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOther, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        cmdOk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmdOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/unicenta/images/ok.png"))); // NOI18N
        cmdOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdOk, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkForcedAccountingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkForcedAccountingStateChanged
        if (chkForcedAccounting.isSelected()) {
            chkForcedAccounting.setText("SI");
        } else {
            chkForcedAccounting.setText("NO");
        }
    }//GEN-LAST:event_chkForcedAccountingStateChanged

    private void cmdOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOkActionPerformed
        try {
            Object taxPayer = createValue();
            int status = this.tdTaxpayer.getUpdateSentence().exec(taxPayer);

            if (status > 0) {
                JOptionPane.showMessageDialog(this, "Se guardó con éxito",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se guardó con éxito",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (BasicException ex) {
            log.error(ex.getMessage());
        }
    }//GEN-LAST:event_cmdOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkForcedAccounting;
    private javax.swing.JButton cmdOk;
    private javax.swing.JPanel jPanelData;
    private javax.swing.JPanel jPanelInformation;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JLabel lblForcedAccounting;
    private javax.swing.JLabel lblIdentification;
    private javax.swing.JLabel lblLegalName;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblRetentionAgent;
    private javax.swing.JLabel lblSpecialTaxPayer;
    private javax.swing.JTextField txtIdentification;
    private javax.swing.JTextField txtLegalName;
    private javax.swing.JTextField txtOther;
    private javax.swing.JTextField txtRetentionAgent;
    private javax.swing.JTextField txtSpecialTaxPayer;
    // End of variables declaration//GEN-END:variables

}
