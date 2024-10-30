package dev.joguenco.pos.ticketsnum;

import com.unicenta.basic.BasicException;
import com.unicenta.data.gui.ComboBoxValModel;
import com.unicenta.data.loader.Datas;
import com.unicenta.data.loader.QBFCompareEnum;
import com.unicenta.data.loader.SentenceList;
import com.unicenta.data.loader.SerializerWrite;
import com.unicenta.data.loader.SerializerWriteBasic;
import com.unicenta.pos.admin.DataLogicAdmin;
import com.unicenta.pos.forms.AppView;
import com.unicenta.pos.reports.ReportEditorCreator;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author jorgeluis
 */
public class TicketsNumFilter extends JPanel implements ReportEditorCreator {

    private SentenceList sentenceListPeople;
    private ComboBoxValModel comboModelPeople;

    public TicketsNumFilter() {
        initComponents();
    }

    @Override
    public void init(AppView app) {

        DataLogicAdmin dataLogicAdmin = (DataLogicAdmin) app
                .getBean("com.unicenta.pos.admin.DataLogicAdmin");

        sentenceListPeople = dataLogicAdmin.getPeopleList();
    }

    public ComboBoxValModel getComboBoxValModelPeople() {
        return comboModelPeople;
    }

    @Override
    public void activate() throws BasicException {
        comboModelPeople = new ComboBoxValModel(sentenceListPeople.list());
        comboModelPeople.setSelectedFirst();
        cbxPeople.setModel(comboModelPeople);
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(
                new Datas[]{Datas.OBJECT, Datas.STRING});
    }

    @Override
    public Object createValue() throws BasicException {
        return new Object[]{
            comboModelPeople.getSelectedKey() == null
            ? QBFCompareEnum.COMP_NONE
            : QBFCompareEnum.COMP_EQUALS,
            comboModelPeople.getSelectedKey()
        };
    }

    public void addActionListener(ActionListener l) {
        cbxPeople.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        cbxPeople.removeActionListener(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxPeople = new javax.swing.JComboBox<>();

        cbxPeople.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxPeople.setPreferredSize(new java.awt.Dimension(90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(cbxPeople, 0, 200, Short.MAX_VALUE)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cbxPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPeople;
    // End of variables declaration//GEN-END:variables
}
