/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontrolinventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilson
 */
public class frmEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form frmEmpleados
     */
    public frmEmpleados() {
        initComponents();
        inicio();
    }
    public void inicio(){
        desactivarInicio();
        provincias();
    }
    public void desactivarInicio(){
        txtCedula.setEnabled(false);
        txtNomUno.setEnabled(false);
        txtNomDos.setEnabled(false);
        txtApellidoP.setEnabled(false);
        txtApellidoM.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtCelular.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSalario.setEnabled(false);
        txtFechaNacimiento.setEnabled(false);
        cbxEstadoCivil.setEnabled(false);
        cbxProvincia.setEnabled(false);
        cbxCanton.setEnabled(false);
        cbxTipoEmpleado.setEnabled(false);        
        rbdMas.setEnabled(false);
        rbdFem.setEnabled(false);
        lblCedula.setVisible(false);
        lblNomUno.setVisible(false);
        lblNomDos.setVisible(false);
        lblApellidoP.setVisible(false);
        lblApellidoM.setVisible(false);
        lblDireccion.setVisible(false);
        lblFechaNacimiento.setVisible(false);
        lblCelular.setVisible(false);
        lblEmail.setVisible(false);  
        lblSexo.setVisible(false);
        lblEstado.setVisible(false);
        lblTelefono.setVisible(false);
        lblTipo.setVisible(false);
        lblProvincia.setVisible(false);
        lblCanton.setVisible(false);
        lblSalario.setVisible(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnModificar.setEnabled(false);
        
    }
    public void activar(){
        txtCedula.setEnabled(true);
        txtNomUno.setEnabled(true);
        txtNomDos.setEnabled(true);
        txtApellidoP.setEnabled(true);
        txtApellidoM.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCelular.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSalario.setEnabled(true);
        txtFechaNacimiento.setEnabled(true);
        cbxEstadoCivil.setEnabled(true);
        cbxProvincia.setEnabled(true);
        cbxCanton.setEnabled(true);
        cbxTipoEmpleado.setEnabled(true);        
        rbdMas.setEnabled(true);
        rbdFem.setEnabled(true);
        btnGuardar.setEnabled(true);
    }
    public void guardar(){
        try {
                Conexion cc = new Conexion();
                Connection cn = cc.conectar();
                String CED_EMP,NOM1_EMP,NOM2_EMP,APE_PAT_EMP,APE_MAT_EMP,SEXO_EMP = "",EST_CIV_EMP,FEC_NAC_EMP,PROV_PER_EMP,CAN_PER_EMP,DIR_EMP,TEL_EMP,CEL_EMP,E_MAIL_EMP,TIP_EMP;
                Float SAL_EMP;
                String sql = "";
                sql = "insert into empleados(CED_EMP,NOM1_EMP,NOM2_EMP,APE_PAT_EMP,APE_MAT_EMP,SEXO_EMP,EST_CIV_EMP,FEC_NAC_EMP,PROV_PER_EMP,CAN_PER_EMP,DIR_EMP,TEL_EMP,CEL_EMP,E_MAIL_EMP,TIP_EMP,SAL_EMP)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                CED_EMP=txtCedula.getText();
                NOM1_EMP=txtNomUno.getText();
                NOM2_EMP=txtNomDos.getText();
                APE_PAT_EMP=txtApellidoP.getText();
                APE_MAT_EMP=txtApellidoM.getText();
                FEC_NAC_EMP=txtFechaNacimiento.getText();
                if(rbdMas.isSelected()){
                    SEXO_EMP="M";
                }else if(rbdFem.isSelected()){
                    SEXO_EMP="F";
                }
                EST_CIV_EMP=cbxEstadoCivil.getSelectedItem().toString();
                PROV_PER_EMP=cbxProvincia.getSelectedItem().toString();
                CAN_PER_EMP=cbxCanton.getSelectedItem().toString();
                DIR_EMP=txtDireccion.getText();
                TEL_EMP=txtTelefono.getText();
                CEL_EMP=txtCelular.getText();
                E_MAIL_EMP=txtEmail.getText();
                TIP_EMP=cbxTipoEmpleado.getSelectedItem().toString();
                SAL_EMP=Float.valueOf(txtSalario.getText());
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, CED_EMP);
                psd.setString(2, NOM1_EMP);
                psd.setString(3, NOM2_EMP);
                psd.setString(4, APE_PAT_EMP);
                psd.setString(5, APE_MAT_EMP);
                psd.setString(6, SEXO_EMP);
                psd.setString(7, EST_CIV_EMP);
                psd.setString(8, FEC_NAC_EMP);
                psd.setString(9, PROV_PER_EMP);
                psd.setString(10, CAN_PER_EMP);
                psd.setString(11, DIR_EMP);
                psd.setString(12, TEL_EMP);
                psd.setString(13, CEL_EMP);
                psd.setString(14, E_MAIL_EMP);
                psd.setString(15, TIP_EMP);                
                psd.setFloat(16, SAL_EMP);

                int n = psd.executeUpdate();
                if (n > 0) {
                    //  JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                    cn.close();
                }

            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(rootPane, "No se inserto");
            }
       int n= JOptionPane.showOptionDialog(null,"Desea crear una cuenta de usuario para este empleado ahora","Elija una opcion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si","No"}, "No");
    if(n==0){
        frmUsuarios u=new frmUsuarios(txtCedula.getText(),"EMPLEADO");
        u.show();
    }else if(n==1){
        
    }
    }
    public void modificar(){
          Conexion cc=new Conexion();
        Connection cn= cc.conectar();
        String gen = null;
                if(rbdMas.isSelected()){
                    gen="M";
                }else if(rbdFem.isSelected()){
                    gen="F";
                }
        String sql="";
        sql="update empleados set NOM1_EMP ='"+txtNomUno.getText()+"',"
                + "NOM2_EMP='"+txtNomDos.getText()+"',"
                + "APE_PAT_EMP='"+txtApellidoP.getText()+"',"
                + "APE_MAT_EMP='"+txtApellidoM.getText()+"',"
                + "SEXO_EMP='"+gen+"',"
                + "EST_CIV_EMP='"+cbxEstadoCivil.getSelectedItem().toString()+"',"
                + "FEC_NAC_EMP='"+txtFechaNacimiento.getText()+"',"
                + "PROV_PER_EMP='"+cbxProvincia.getSelectedItem().toString()+"',"
                + "CAN_PER_EMP='"+cbxCanton.getSelectedItem().toString()+"',"
                + "DIR_EMP='"+txtDireccion.getText()+"',"
                + "TEL_EMP='"+txtTelefono.getText()+"',"
                + "CEL_EMP='"+txtCelular.getText()+"',"
                + "E_MAIL_EMP='"+txtEmail.getText()+"'"
                + "TIP_EMP='"+cbxTipoEmpleado.getSelectedItem().toString()+"',"
                + "SAL_EMP='"+txtSalario.getText()+"',"
                + " where CED_EMP='"+txtCedula.getText().toString()+"'";
        try {
             PreparedStatement psd=cn.prepareStatement(sql);
             int n=psd.executeUpdate();
             if(n>0){
                 JOptionPane.showMessageDialog(null, "Se actualizo correctamente");
             }
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
         }
    }
    public void eliminar(){
        int n=JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar");
        if(n==0){
        Conexion cc=new Conexion();
        Connection cn=cc.conectar();
        String sql="";
        sql="delete from empleados where CED_EMP='"+txtCedula.getText().toString()+"'";
            try {
                PreparedStatement psd=cn.prepareStatement(sql);
              int c=psd.executeUpdate();
             if(c>0){
                 JOptionPane.showMessageDialog(null, "Se elimino correctamente");
             }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    public boolean controlError(){
        boolean error=false;
         if(txtCedula.getText().isEmpty()){
            txtCedula.requestFocus();
            lblCedula.setVisible(true);
            error=true;
        }else if(!verific_cedula.verificaCedula(txtCedula.getText())){
            txtCedula.requestFocus();
            lblCedula.setText("Ingrese una cedula correcta");
            lblCedula.setVisible(true);
            error=true;
        }
        return error;
    }
    
    public void provincias() {
        cbxProvincia.removeAllItems();
        cbxProvincia.addItem("SELECCIONE UNA PROVINCIA");
        cbxProvincia.addItem("AZUAY");
        cbxProvincia.addItem("BOLÍVAR");
        cbxProvincia.addItem("CAÑAR");
        cbxProvincia.addItem("CARCHI");
        cbxProvincia.addItem("CHIMBORAZO");
        cbxProvincia.addItem("COTOPAXI");
        cbxProvincia.addItem("EL ORO");
        cbxProvincia.addItem("ESMERALDAS");
        cbxProvincia.addItem("GALÁPAGOS");
        cbxProvincia.addItem("GUAYAS");
        cbxProvincia.addItem("IMBABURA");
        cbxProvincia.addItem("LOJA");
        cbxProvincia.addItem("LOS RÍOS");
        cbxProvincia.addItem("MANABÍ");
        cbxProvincia.addItem("MORONA SANTIAGO");
        cbxProvincia.addItem("NAPO");
        cbxProvincia.addItem("ORELLANA");
        cbxProvincia.addItem("PASTAZA");
        cbxProvincia.addItem("PICHINCHA");
        cbxProvincia.addItem("SANTA ELENA");
        cbxProvincia.addItem("SANTO DOMINGO DE LOS TSÁCHILAS");
        cbxProvincia.addItem("SUCUMBÍOS");
        cbxProvincia.addItem("TUNGURAHUA");
        cbxProvincia.addItem("ZAMORA CHINCHIPE");
        cbxProvincia.setToolTipText("SELECCIONE UNO");
    }

    public void cantones() {
        if (cbxProvincia.getSelectedIndex() == 1) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("CHORDELEG");
            cbxCanton.addItem("CUENCA");
            cbxCanton.addItem("EL PAN");
            cbxCanton.addItem("GIRÓN");
            cbxCanton.addItem("GUACHAPALA");
            cbxCanton.addItem("GUALACEO");
            cbxCanton.addItem("NABÓN");
            cbxCanton.addItem("OÑA");
            cbxCanton.addItem("PAUTE");
            cbxCanton.addItem("PONCE ENRIQUEZ");
            cbxCanton.addItem("PUCARÁ");
            cbxCanton.addItem("SAN FERNANDO");
            cbxCanton.addItem("SANTA ISABEL");
            cbxCanton.addItem("SEVILLA DE ORO");
            cbxCanton.addItem("SÍGSIG");

        } else if (cbxProvincia.getSelectedIndex() == 2) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("CALUMA");
            cbxCanton.addItem("CHILLANES");
            cbxCanton.addItem("CHIMBO");
            cbxCanton.addItem("ECHEANDÍA");
            cbxCanton.addItem("GUARANDA");
            cbxCanton.addItem("LAS NAVES");
            cbxCanton.addItem("SAN MIGUEL");
        } else if (cbxProvincia.getSelectedIndex() == 3) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("AZOGUES");
            cbxCanton.addItem("BIBLIÁN");
            cbxCanton.addItem("CAÑAR");
            cbxCanton.addItem("DÉLEG");
            cbxCanton.addItem("EL TAMBO");
            cbxCanton.addItem("LA TRONCAL ");
            cbxCanton.addItem("SUSCAL");
        } else if (cbxProvincia.getSelectedIndex() == 4) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("BOLÍVAR");
            cbxCanton.addItem("ESPEJO");
            cbxCanton.addItem("MIRA");
            cbxCanton.addItem("MONTÚFAR");
            cbxCanton.addItem("SAN PEDRO DE HUACA");
            cbxCanton.addItem("TULCÁN");
        } else if (cbxProvincia.getSelectedIndex() == 5) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ALAUSÍ");
            cbxCanton.addItem("CHAMBO");
            cbxCanton.addItem("CHUNCHI");
            cbxCanton.addItem("COLTA");
            cbxCanton.addItem("CUMANDÁ");
            cbxCanton.addItem("GUAMOTE");
            cbxCanton.addItem("GUANO");
            cbxCanton.addItem("PALLATANGA");
            cbxCanton.addItem("PENIPE");
            cbxCanton.addItem("RIOBAMBA");
        } else if (cbxProvincia.getSelectedIndex() == 6) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("LA MANÁ");
            cbxCanton.addItem("LATACUNGA");
            cbxCanton.addItem("PANGUA");
            cbxCanton.addItem("PUJILÍ");
            cbxCanton.addItem("SALCEDO");
            cbxCanton.addItem("SAQUISILÍ");
            cbxCanton.addItem("SIGCHOS");

        } else if (cbxProvincia.getSelectedIndex() == 7) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ARENILLAS");
            cbxCanton.addItem("ATAHUALPA");
            cbxCanton.addItem("BALSAS");
            cbxCanton.addItem("CHILLA");
            cbxCanton.addItem("EL GUABO");
            cbxCanton.addItem("HUAQUILLAS");
            cbxCanton.addItem("LAS LAJAS");
            cbxCanton.addItem("MACHALA");
            cbxCanton.addItem("MARCABELÍ");
            cbxCanton.addItem("PASAJE");
            cbxCanton.addItem("PIÑAS");
            cbxCanton.addItem("PORTOVELO");
            cbxCanton.addItem("SANTA ROSA");
            cbxCanton.addItem("ZARUMA");
        } else if (cbxProvincia.getSelectedIndex() == 8) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ATACAMES");
            cbxCanton.addItem("ELOY ALFARO");
            cbxCanton.addItem("ESMERALDAS");
            cbxCanton.addItem("MUISNE");
            cbxCanton.addItem("QUININDÉ");
            cbxCanton.addItem("RIOVERDE");
            cbxCanton.addItem("SAN LORENZO");
        } else if (cbxProvincia.getSelectedIndex() == 9) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ISABELA");
            cbxCanton.addItem("SAN CRISTÓBAL");
            cbxCanton.addItem("SANTA CRUZ");
        } else if (cbxProvincia.getSelectedIndex() == 10) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ALFREDO BAQUERIZO MORENO");
            cbxCanton.addItem("BALAO");
            cbxCanton.addItem("BALZAR");
            cbxCanton.addItem("COLIMES");
            cbxCanton.addItem("DAULE");
            cbxCanton.addItem("EL EMPALME");
            cbxCanton.addItem("EL TRIUNFO");
            cbxCanton.addItem("DURÁN");
            cbxCanton.addItem("GENERAL ANTONIO ELIZALDE");
            cbxCanton.addItem("PLAYAS");
            cbxCanton.addItem("GUAYAQUIL");
            cbxCanton.addItem("ISIDRO AYORA");
            cbxCanton.addItem("LOMAS DE SARGENTILLO");
            cbxCanton.addItem("MARCELINO MARIDUEÑA");
            cbxCanton.addItem("MILAGRO");
            cbxCanton.addItem("NARANJAL");
            cbxCanton.addItem("NARANJITO");
            cbxCanton.addItem("NOBOL");
            cbxCanton.addItem("PALESTINA");
            cbxCanton.addItem("PEDRO CARBO");
            cbxCanton.addItem("SALITRE");
            cbxCanton.addItem("SAMBORONDÓN");
            cbxCanton.addItem("SANTA LUCÍA");
            cbxCanton.addItem("SIMÓN BOLÍVAR");
            cbxCanton.addItem("YAGUACHI");
        } else if (cbxProvincia.getSelectedIndex() == 11) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ANTONIO ANTE");
            cbxCanton.addItem("COTACACHI");
            cbxCanton.addItem("IBARRA");
            cbxCanton.addItem("OTAVALO");
            cbxCanton.addItem("PIMAMPIRO");
            cbxCanton.addItem("SAN MIGUEL DE URCUQUÍ");
        } else if (cbxProvincia.getSelectedIndex() == 12) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CALVAS");
            cbxCanton.addItem("CATAMAYO");
            cbxCanton.addItem("CELICA");
            cbxCanton.addItem("CHAGUARPAMBA");
            cbxCanton.addItem("ESPÍNDOLA");
            cbxCanton.addItem("GONZANAMÁ");
            cbxCanton.addItem("LOJA");
            cbxCanton.addItem("MACARÁ");
            cbxCanton.addItem("OLMEDO");
            cbxCanton.addItem("PALTAS");
            cbxCanton.addItem("PINDAL");
            cbxCanton.addItem("PUYANGO");
            cbxCanton.addItem("QUILANGA");
            cbxCanton.addItem("SARAGURO");
            cbxCanton.addItem("SOZORANGA");
        } else if (cbxProvincia.getSelectedIndex() == 13) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("BABA");
            cbxCanton.addItem("BABAHOYO");
            cbxCanton.addItem("BUENA FE");
            cbxCanton.addItem("MOCACHE");
            cbxCanton.addItem("MONTALVO");
            cbxCanton.addItem("PALENQUE");
            cbxCanton.addItem("PUEBLOVIEJO");
            cbxCanton.addItem("QUEVEDO");
            cbxCanton.addItem("QUINSALOMA");
            cbxCanton.addItem("URDANETA");
            cbxCanton.addItem("VALENCIA");
            cbxCanton.addItem("VENTANAS");
            cbxCanton.addItem("VINCES");
        } else if (cbxProvincia.getSelectedIndex() == 14) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("BABA");
            cbxCanton.addItem("BABAHOYO");
            cbxCanton.addItem("BUENA FE");
            cbxCanton.addItem("MOCACHE");
            cbxCanton.addItem("MONTALVO");
            cbxCanton.addItem("PALENQUE");
            cbxCanton.addItem("PUEBLOVIEJO");
            cbxCanton.addItem("QUEVEDO");
            cbxCanton.addItem("QUINSALOMA");
            cbxCanton.addItem("URDANETA");
            cbxCanton.addItem("VALENCIA");
            cbxCanton.addItem("VENTANAS");
            cbxCanton.addItem("VINCES");
        } else if (cbxProvincia.getSelectedIndex() == 15) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("BOLÍVAR");
            cbxCanton.addItem("CHONE");
            cbxCanton.addItem("EL CARMEN");
            cbxCanton.addItem("FLAVIO ALFARO");
            cbxCanton.addItem("JAMA");
            cbxCanton.addItem("JARAMIJÓ");
            cbxCanton.addItem("JIPIJAPA");
            cbxCanton.addItem("JUNÍN");
            cbxCanton.addItem("MANTA");
            cbxCanton.addItem("MONTECRISTI");
            cbxCanton.addItem("OLMEDO");
            cbxCanton.addItem("PAJÁN");
            cbxCanton.addItem("PEDERNALES");
            cbxCanton.addItem("PICHINCHA");
            cbxCanton.addItem("PORTOVIEJO");
            cbxCanton.addItem("PUERTO LÓPEZ");
            cbxCanton.addItem("ROCAFUERTE");
            cbxCanton.addItem("SAN VICENTE");
            cbxCanton.addItem("SANTA ANA");
            cbxCanton.addItem("SUCRE");
            cbxCanton.addItem("TOSAGUA");
            cbxCanton.addItem("VEINTICUATRO DE MAYO");
        } else if (cbxProvincia.getSelectedIndex() == 16) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ARCHIDONA");
            cbxCanton.addItem("CARLOS JULIO AROSEMENA TOLA");
            cbxCanton.addItem("EL CHACO");
            cbxCanton.addItem("QUIJOS");
            cbxCanton.addItem("TENA");
        } else if (cbxProvincia.getSelectedIndex() == 17) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("AGUARICO");
            cbxCanton.addItem("ORELLANA");
            cbxCanton.addItem("LA JOYA DE LOS SACHAS");
            cbxCanton.addItem("LORETO");
        } else if (cbxProvincia.getSelectedIndex() == 18) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("ARAJUNO");
            cbxCanton.addItem("MERA");
            cbxCanton.addItem("PASTAZA");
            cbxCanton.addItem("SANTA CLARA");
        } else if (cbxProvincia.getSelectedIndex() == 19) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("QUITO");
            cbxCanton.addItem("CAYAMBE");
            cbxCanton.addItem("MEJÍA");
            cbxCanton.addItem("PEDRO MONCAYO");
            cbxCanton.addItem("PEDRO VICENTE MALDONADO");
            cbxCanton.addItem("PUERTO QUITO");
            cbxCanton.addItem("RUMIÑAHUI");
            cbxCanton.addItem("SAN MIGUEL DE LOS BANCOS");
        } else if (cbxProvincia.getSelectedIndex() == 20) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("LA LIBERTAD");
            cbxCanton.addItem("SALINAS");
            cbxCanton.addItem("SANTA ELENA");
        } else if (cbxProvincia.getSelectedIndex() == 21) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("SANTO DOMINGO");
            cbxCanton.addItem("LA CONCORDIA");
        } else if (cbxProvincia.getSelectedIndex() == 22) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UNO");
            cbxCanton.addItem("CASCALES");
            cbxCanton.addItem("CUYABENO");
            cbxCanton.addItem("GONZALO PIZARRO");
            cbxCanton.addItem("LAGO AGRIO");
            cbxCanton.addItem("PUTUMAYO");
            cbxCanton.addItem("SHUSHUFINDI");
            cbxCanton.addItem("SUCUMBÍOS");
        } else if (cbxProvincia.getSelectedIndex() == 23) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("AMBATO");
            cbxCanton.addItem("BAÑOS");
            cbxCanton.addItem("CEVALLOS");
            cbxCanton.addItem("MOCHA");
            cbxCanton.addItem("PATATE");
            cbxCanton.addItem("PELILEO");
            cbxCanton.addItem("QUERO");
            cbxCanton.addItem("SANTIAGO DE PÍLLARO");
            cbxCanton.addItem("TISALEO");
        } else if (cbxProvincia.getSelectedIndex() == 24) {
            cbxCanton.removeAllItems();
            cbxCanton.addItem("SELECCIONE UN CANTÓN");
            cbxCanton.addItem("CENTINELA DEL CÓNDOR");
            cbxCanton.addItem("CHINCHIPE");
            cbxCanton.addItem("EL PANGUI");
            cbxCanton.addItem("NANGARITZA");
            cbxCanton.addItem("PALANDA");
            cbxCanton.addItem("PAQUISHA");
            cbxCanton.addItem("YACUAMBI");
            cbxCanton.addItem("YANTZAZA");
            cbxCanton.addItem("ZAMORA");
        }
    }
    public void cedula(java.awt.event.KeyEvent evt){
          int n = txtCedula.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < '0' || c > '9') || n > 9) {
            evt.consume();

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNomUno = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblNomUno = new javax.swing.JLabel();
        lblApellidoP = new javax.swing.JLabel();
        lblApellidoM = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNomDos = new javax.swing.JTextField();
        lblNomDos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox();
        lblProvincia = new javax.swing.JLabel();
        cbxCanton = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        lblCanton = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox();
        lblEstado = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rbdMas = new javax.swing.JRadioButton();
        rbdFem = new javax.swing.JRadioButton();
        lblSexo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbxTipoEmpleado = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Cédula:");

        jLabel2.setText("Primer Nombre:");

        jLabel3.setText("Apellido Paterno:");

        jLabel4.setText("Apellido Materno:");

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNomUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomUnoKeyTyped(evt);
            }
        });

        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });

        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 0, 0));
        lblCedula.setText("Ingrese la cédula del empleado");

        lblNomUno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblNomUno.setForeground(new java.awt.Color(255, 0, 0));
        lblNomUno.setText("Ingrese el primer nombre del empleado");

        lblApellidoP.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblApellidoP.setForeground(new java.awt.Color(255, 0, 0));
        lblApellidoP.setText("Ingrese el apellido paterno del empleado");

        lblApellidoM.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblApellidoM.setForeground(new java.awt.Color(255, 0, 0));
        lblApellidoM.setText("Ingrese el apellido materno del empleado");

        jLabel23.setText("Segundo Nombre:");

        txtNomDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomDosKeyTyped(evt);
            }
        });

        lblNomDos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblNomDos.setForeground(new java.awt.Color(255, 0, 0));
        lblNomDos.setText("Ingrese el segundo nombre del empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblApellidoP)
                            .addComponent(lblNomUno)
                            .addComponent(txtNomUno, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtApellidoP))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4))
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidoM)
                            .addComponent(lblNomDos)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtApellidoM, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomDos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCedula)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCedula)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel23)
                    .addComponent(txtNomDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomUno)
                    .addComponent(lblNomDos))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoP)
                    .addComponent(lblApellidoM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1482969987_trash_bin.png"))); // NOI18N
        btnEliminar.setText("Eliminar");

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEmpleados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Cambria", 0, 48)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleados.png"))); // NOI18N
        jLabel12.setText("EMPLEADOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("Provincia:");

        cbxProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProvinciaItemStateChanged(evt);
            }
        });
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });

        lblProvincia.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblProvincia.setForeground(new java.awt.Color(255, 0, 0));
        lblProvincia.setText("Elija una provincia");

        cbxCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCantonActionPerformed(evt);
            }
        });

        jLabel14.setText("Cantón:");

        lblCanton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblCanton.setForeground(new java.awt.Color(255, 0, 0));
        lblCanton.setText("Elija un cantón");

        jLabel8.setText("Dirección:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(255, 0, 0));
        lblDireccion.setText("Ingrese la dirección del empleado");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccion)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProvincia)
                            .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCanton)
                    .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCanton))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProvincia)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Celular:");

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        lblCelular.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblCelular.setForeground(new java.awt.Color(255, 0, 0));
        lblCelular.setText("Ingrese el celular del empleado");

        jLabel5.setText("Teléfono:");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 0, 0));
        lblTelefono.setText("Ingrese el teléfono del empleado");

        jLabel7.setText("E-mail:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblEmail.setText("Ingrese el e-mail del empleado");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono))
                .addGap(51, 51, 51)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmail))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCelular))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTelefono))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setText("Estado Civil:");

        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTERO(A)", "CASADO(A)", "DIVORCIADO(A)", "VIUDO(A)", "UNION LIBRE" }));

        lblEstado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 0, 0));
        lblEstado.setText("Escoja un estado civil");

        jLabel9.setText("Sexo:");

        buttonGroup1.add(rbdMas);
        rbdMas.setText("Masculino");

        buttonGroup1.add(rbdFem);
        rbdFem.setText("Femenino");

        lblSexo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 0, 0));
        lblSexo.setText("Elija un sexo");

        jLabel10.setText("Fecha de Nacimiento:");

        lblFechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(255, 0, 0));
        lblFechaNacimiento.setText("Ingrese la fecha de nacimiento");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEstado)
                    .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(rbdMas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbdFem))
                    .addComponent(lblSexo))
                .addGap(85, 85, 85)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaNacimiento))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbdMas)
                            .addComponent(rbdFem)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSexo))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstado))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel17.setText("Tipo:");

        cbxTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "SECRETARIO", "CAJERO", "BODEGUERO" }));

        jLabel18.setText("Salario:");

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 0, 0));
        lblTipo.setText("Elija tipo de empleado");

        lblSalario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblSalario.setForeground(new java.awt.Color(255, 0, 0));
        lblSalario.setText("Ingrese el salario");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalario)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbxTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipo)
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalario)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cbxCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCantonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCantonActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        activar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void cbxProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProvinciaItemStateChanged
        // TODO add your handling code here:
        cantones();
    }//GEN-LAST:event_cbxProvinciaItemStateChanged

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        cedula(evt);
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtNomUnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomUnoKeyTyped
        // TODO add your handling code here:
        String t =txtNomUno.getText().toUpperCase();
        txtNomUno.setText(t);
         int n = txtNomUno.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') || n > 19) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNomUnoKeyTyped

    private void txtNomDosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomDosKeyTyped
        // TODO add your handling code here:
        String t =txtNomDos.getText().toUpperCase();
        txtNomDos.setText(t);
         int n = txtNomDos.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') || n > 19) {
            evt.consume();

        }
    }//GEN-LAST:event_txtNomDosKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        // TODO add your handling code here:
        String t =txtApellidoP.getText().toUpperCase();
        txtApellidoP.setText(t);
         int n = txtApellidoP.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') || n > 19) {
            evt.consume();

        }
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        // TODO add your handling code here:
        String t =txtApellidoM.getText().toUpperCase();
        txtApellidoM.setText(t);
         int n = txtApellidoM.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') || n > 19) {
            evt.consume();

        }
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        // TODO add your handling code here:
        int n = txtCelular.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < '0' || c > '9') || n > 9) {
            evt.consume();

        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
         int n = txtTelefono.getText().toString().length();
        char c;
        c = evt.getKeyChar();
        if ((c < '0' || c > '9') || n > 8) {
            evt.consume();

        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxCanton;
    private javax.swing.JComboBox cbxEstadoCivil;
    private javax.swing.JComboBox cbxProvincia;
    private javax.swing.JComboBox cbxTipoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidoM;
    private javax.swing.JLabel lblApellidoP;
    private javax.swing.JLabel lblCanton;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNomDos;
    private javax.swing.JLabel lblNomUno;
    private javax.swing.JLabel lblProvincia;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JRadioButton rbdFem;
    private javax.swing.JRadioButton rbdMas;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNomDos;
    private javax.swing.JTextField txtNomUno;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
