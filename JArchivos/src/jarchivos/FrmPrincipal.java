package jarchivos;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FrmPrincipal extends javax.swing.JFrame {

    //atributo de la clase privado que nos ayudara a asaber si un archivo fue abierto
    private boolean arAbierto;

    public FrmPrincipal() {
        initComponents();
        //en el constructor ponemos una ruta vacia al label
        lblRuta.setText("");
        //tambien indicamos que no esta abierto ningun archivo
        arAbierto = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblRuta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblLineas = new javax.swing.JLabel();
        lblLon = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnuAbrir = new javax.swing.JMenuItem();
        MnuGuardar = new javax.swing.JMenuItem();
        MnuEliminar = new javax.swing.JMenuItem();
        MunCerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRuta.setText("jLabel2");

        jLabel2.setText("Ruta:");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea);

        jLabel3.setText("Lineas:");

        jLabel4.setText("Longitud");

        lblLineas.setText("0");

        lblLon.setText("0");

        jMenu1.setText("File");

        MnuAbrir.setText("Abrir");
        MnuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(MnuAbrir);

        MnuGuardar.setText("Guardar");
        MnuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(MnuGuardar);

        MnuEliminar.setText("Eliminar");
        MnuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnuEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(MnuEliminar);

        MunCerrar.setText("Cerrar Archivo");
        MunCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MunCerrarActionPerformed(evt);
            }
        });
        jMenu1.add(MunCerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblRuta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLineas)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLon)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRuta)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblLineas)
                    .addComponent(lblLon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodos
    
    
    //metodo para pedir ruta al usuario con un formulario de dialogo 
    //en caso de presionar al boton de cancelar se regresa un valor vacion
    private String pedirRutaUsuario() {
        
        
        String path = "";
        //creamos una clase la cual nos servira para mostrar un cuadro de dialogo 
        //para elegui un archivo

        //obtemos la ruta del escritrio para empezar a buscar desde esa ruta
        String ru = System.getProperty("user.home");
        ru += "\\Desktop\\";

        JFileChooser fc = new JFileChooser(ru);
        //creamos una clase para filtrar solo archivos de texto
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto Txt", "txt");

        //asignmaos los filtros 
        //indicamos que slo acepte archivos
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(filtro);

        //mostramos el cuadro de dialogo
        int res = fc.showSaveDialog(this);

        if (res == JFileChooser.APPROVE_OPTION) {
            path = fc.getSelectedFile().getPath() + ".txt";

            mostrarMensaje(path);

        }

        return path;
    }

    //metodo que muestra un mensaje a travez de un cuadro de dialogo
    private void mostrarMensaje(String men) {

        JOptionPane.showMessageDialog(this, men);

    }

    //------------------------------------------
    //metodo que lee un archivo de texto 
    //parametros recibimos una ruta
    private void leeArchivo(String ruta) {

        try {
            //creamos una clase la cual leera todo el contedido
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            //creamos dos varibles temporales 
            //aux leera linea por linea
            String aux;
            //lec almacenara todo el contenido leido
            String lec = "";

            //leemos con un bucle hasta que nuestro archivo ya no tenga contenido
            while ((aux = br.readLine()) != null) {
                lec += aux + "\n";
            }

            //asignamos lo leido a nuestro textarea
            txtArea.setText(lec);

            //importante cerramos el archivo
            br.close();
            fr.close();

        } catch (IOException ex) {
            mostrarMensaje("Erro al leer el archivo" + ruta);
        }

    }

    //-------------------------------------------
    //metodo que actualiza un archivo de texto
    //paramretros la ruta del archiuvo
    private void actualizaArchivo(String ruta) {
        try {

            FileWriter fw = new FileWriter(ruta);

            fw.write(txtArea.getText());

            fw.close();

        } catch (IOException ex) {
            mostrarMensaje("Erro al actualizar archivo");

        }

    }

    //metodo que crea un archivo y escribe en el
    private void crearArchivo(String ruta) {

        try {

            //creamos una objeto de la clase file
            File f = new File(ruta);
            //accedemos al metodo createnew file
            f.createNewFile();

            //mostramos un mensjae para mostrar que el archivo se a creado
            mostrarMensaje("Creado con exito");

        } catch (IOException ex) {

        }

        //actualizamos el contenido del nuevo archivo
        actualizaArchivo(ruta);

    }

    //metodo que limpia campos
    private void limpiaCampos() {
        txtArea.setText("");
        lblRuta.setText("");
        arAbierto = false;
        actualizaLineas();
    }

    //metodo que actualiza los labels en donde se muestra la informacion de cantidad de lineas y longitud de texto
    private void actualizaLineas() {

        //longitud del texto
        int lon = txtArea.getText().length();
        //asiganmos la longitud del texto al label
        lblLon.setText(Integer.toString(lon));

        //lineas del texto
        int lineas;
        //asigamos la varible lineas al metodo getlineCount del textarea

        lineas = txtArea.getLineCount();
        //mostramos las lineas 
        lblLineas.setText(Integer.toString(lineas));
    }


    
    //evento al presionar el menu de abrir
    private void MnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuAbrirActionPerformed

        //creamos una clase la cual nos servira para mostrar un cuadro de dialogo 
        //para elegui un archivo
        //obtemos la ruta del escritrio para empezar a buscar desde esa ruta
        String ru = System.getProperty("user.home");
        ru += "\\Desktop\\";

        //creamos un cuadro de dialogo para seleccionar un archivo
        JFileChooser fc = new JFileChooser(ru);
        //creamos una clase para filtrar solo archivos de texto
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto Txt", "txt");

        //asignmaos los filtros 
        fc.setFileFilter(filtro);
        fc.setAcceptAllFileFilterUsed(false);

        //mostramos el cuadro de dialogo
        int res = fc.showOpenDialog(this);

        //en caso de que el usuario haya puesto aceptar en el cuadro de dialogo
        if (res == JFileChooser.APPROVE_OPTION) {

            lblRuta.setText(fc.getSelectedFile().getPath());
            leeArchivo(lblRuta.getText());
            actualizaLineas();
            this.arAbierto = true;
        }

    }//GEN-LAST:event_MnuAbrirActionPerformed

    
    //evento que sucede cuando el usuario presina una tecla en el textAre
    //metodo que se ejecuta cuando el usuario presiona una tecla
    private void txtAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaKeyReleased
        // TODO add your handling code here:

        actualizaLineas();


    }//GEN-LAST:event_txtAreaKeyReleased

    //evento que sucede cuando el usuario presiona en lemento de guardar
    private void MnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuGuardarActionPerformed
     
        if (arAbierto) {
            File f = new File(lblRuta.getText());
            if (!f.exists()) {
                limpiaCampos();
            } else {
                actualizaArchivo(lblRuta.getText());
            }
            
        } else if (!txtArea.getText().isEmpty()) {

            String path = pedirRutaUsuario();

            if (!path.isEmpty()) {
                crearArchivo(path);
                lblRuta.setText(path);
                arAbierto = true;

            }
        }

    }//GEN-LAST:event_MnuGuardarActionPerformed

    //evento que sucede al presionar el menu de elimar
    private void MnuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnuEliminarActionPerformed

        //comprobamos que este abierto archivo
        if (arAbierto) {

            File f = new File(lblRuta.getText());
            if (f.exists()) {

                //creamos un cuadro de dialogo el cual pregunte si decia eliminar
                int re = JOptionPane.showConfirmDialog(this, "Eliminar archivo" + lblRuta.getText());

                //en caso de que la respuesta sea que si
                if (re == JOptionPane.OK_OPTION) {

                    //eliminamos el archivo
                    f.delete();

                    //mostramos u
                    mostrarMensaje(f.getName() + " borrado con exito");

                    //LIMPIAMOS LOS CAMPOS
                    limpiaCampos();

                }

            } else {
                mostrarMensaje("no existe ningun archivo abierto");
            }
        }
    }//GEN-LAST:event_MnuEliminarActionPerformed

    
    
    private void MunCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MunCerrarActionPerformed
        limpiaCampos();
    }//GEN-LAST:event_MunCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MnuAbrir;
    private javax.swing.JMenuItem MnuEliminar;
    private javax.swing.JMenuItem MnuGuardar;
    private javax.swing.JMenuItem MunCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLineas;
    private javax.swing.JLabel lblLon;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
