package visual;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PresupuestosFinetwork extends javax.swing.JFrame {
    
    DefaultTableModel t1 = new DefaultTableModel();

    public PresupuestosFinetwork() {
        initComponents();
        
        //Centrar Ventana
        this.setLocationRelativeTo(null);
       
        
        
        //Asigno el modelo de tabla y los ids
        String ids[] = {"Producto", "Precio"};
        t1.setColumnIdentifiers(ids);
        jTable1.setModel(t1);
        
        
        //Mostrar productos más ancho
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        
    }
    
    

   

    
    
    
    public void insertarInformacionTabla(String pNombre, double pPrecio){
        DefaultTableModel dt1 = (DefaultTableModel) jTable1.getModel();
            Vector v = new Vector();
            v.add(pNombre);
            v.add(pPrecio);
            dt1.addRow(v);
        
            sumaTotal();
    }
    
    public void eliminarCelda() {
        //Si la fila seleccionada es distinta de -1(no existe) entonces no se habrá seleccionado ninguna fila
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel t1 = (DefaultTableModel) jTable1.getModel();
            t1.removeRow(filaSeleccionada);
            
            
            //Vuelvo a llamar al método sumaTotal() para que se actualice el precio de la tarifa al eliminar una celda
            sumaTotal();
        } 
        else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para eliminar.");
        }
    }
    
    public void sumaTotal() {
        //Cálculo del precio de la Tarifa a contratar
        int numeroFila = jTable1.getRowCount();
        double total = 0;
        
        for (int i = 0; i < numeroFila; i++){
            double valor = Double.parseDouble(jTable1.getValueAt(i, 1).toString());
            
            total += valor;
        }
        // Formatear Tarifa
        DecimalFormat df = new  DecimalFormat("000.00");
        String totalConFormato = df.format(total);
        jTextFieldPrecioTarifa.setText(totalConFormato);
        
        //Cálculo del ahorro en comparación con lo que pagaba en la otra compañía
        double precioActual = Double.parseDouble(jTextFieldPrecioActual.getText());
        double ahorroTotal = precioActual - total;
        jTextFieldAhorroTotal.setText(String.valueOf(ahorroTotal));
        
        // Formatear el ahorro total
        String ahorroTotalConFormato = df.format(ahorroTotal);
        jTextFieldAhorroTotal.setText(ahorroTotalConFormato);
        
        //Cambiar color dependiendo del ahorro
        if(ahorroTotal < 0){
            jTextFieldAhorroTotal.setBackground(Color.red);
        }
        else if(ahorroTotal > 0) {
            jTextFieldAhorroTotal.setBackground(Color.green);
        }
        else {
            jTextFieldAhorroTotal.setBackground(Color.white);
        }
          
    }
    
    
    
    
    
    

    

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanelFibraMovil = new javax.swing.JPanel();
        jButton600Mb10GB = new javax.swing.JButton();
        jButton600Mb55GB = new javax.swing.JButton();
        jButton1GB150GB = new javax.swing.JButton();
        jButton1GBIlimitados = new javax.swing.JButton();
        jPanelAdicionales = new javax.swing.JPanel();
        jButtonAdicional5GB = new javax.swing.JButton();
        jButtonAdicional20GB = new javax.swing.JButton();
        jButtonAdicional75GB = new javax.swing.JButton();
        jButtonAdicional150GB = new javax.swing.JButton();
        jPanelSegundaFibra = new javax.swing.JPanel();
        jButtonSegundaFibra300Mb = new javax.swing.JButton();
        jPanelTV = new javax.swing.JPanel();
        jButtonEligeTV = new javax.swing.JButton();
        jButtonEligeTVPremium = new javax.swing.JButton();
        jPanelFijo = new javax.swing.JPanel();
        jButtonFijo100min = new javax.swing.JButton();
        jButtonFijoIlimitadas = new javax.swing.JButton();
        jPanelMovil = new javax.swing.JPanel();
        jButton10GB = new javax.swing.JButton();
        jButton30GB = new javax.swing.JButton();
        jButton75GB = new javax.swing.JButton();
        jButton150GB = new javax.swing.JButton();
        jButtonIlimitados = new javax.swing.JButton();
        jPanelFibra = new javax.swing.JPanel();
        jButtonFibra300Mb = new javax.swing.JButton();
        jButtonFibra600Mb = new javax.swing.JButton();
        jButtonFibra1GB = new javax.swing.JButton();
        jPanelFactura = new javax.swing.JPanel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCompania = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldPrecioActual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrecioTarifa = new javax.swing.JTextField();
        jTextFieldAhorroTotal = new javax.swing.JTextField();
        jButtonEliminarCeldas = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FINETWORK");
        setMaximumSize(new java.awt.Dimension(1250, 700));
        setPreferredSize(new java.awt.Dimension(1250, 800));
        setResizable(false);

        bg.setBackground(new java.awt.Color(95, 10, 255));
        bg.setMaximumSize(new java.awt.Dimension(1200, 1000));
        bg.setPreferredSize(new java.awt.Dimension(1200, 1000));

        jPanelFibraMovil.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFibraMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fibra + Móvil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelFibraMovil.setForeground(new java.awt.Color(255, 251, 250));

        jButton600Mb10GB.setText("600Mb + 10GB");
        jButton600Mb10GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton600Mb10GBActionPerformed(evt);
            }
        });

        jButton600Mb55GB.setText("600Mb + 55GB");
        jButton600Mb55GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton600Mb55GBActionPerformed(evt);
            }
        });

        jButton1GB150GB.setText("1GB + 150GB");
        jButton1GB150GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GB150GBActionPerformed(evt);
            }
        });

        jButton1GBIlimitados.setText("1GB + Ilimitados");
        jButton1GBIlimitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1GBIlimitadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFibraMovilLayout = new javax.swing.GroupLayout(jPanelFibraMovil);
        jPanelFibraMovil.setLayout(jPanelFibraMovilLayout);
        jPanelFibraMovilLayout.setHorizontalGroup(
            jPanelFibraMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFibraMovilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFibraMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton600Mb10GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton600Mb55GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1GB150GB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1GBIlimitados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFibraMovilLayout.setVerticalGroup(
            jPanelFibraMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFibraMovilLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton600Mb10GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton600Mb55GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1GB150GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1GBIlimitados, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAdicionales.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdicionales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Líneas Adicionales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelAdicionales.setForeground(new java.awt.Color(255, 251, 250));

        jButtonAdicional5GB.setText("5GB");
        jButtonAdicional5GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicional5GBActionPerformed(evt);
            }
        });

        jButtonAdicional20GB.setText("20GB");
        jButtonAdicional20GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicional20GBActionPerformed(evt);
            }
        });

        jButtonAdicional75GB.setText("75GB");
        jButtonAdicional75GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicional75GBActionPerformed(evt);
            }
        });

        jButtonAdicional150GB.setText("150GB");
        jButtonAdicional150GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicional150GBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdicionalesLayout = new javax.swing.GroupLayout(jPanelAdicionales);
        jPanelAdicionales.setLayout(jPanelAdicionalesLayout);
        jPanelAdicionalesLayout.setHorizontalGroup(
            jPanelAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdicional5GB, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jButtonAdicional20GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdicional75GB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdicional150GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAdicionalesLayout.setVerticalGroup(
            jPanelAdicionalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdicionalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdicional5GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdicional20GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdicional75GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAdicional150GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelSegundaFibra.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSegundaFibra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Segunda Fibra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelSegundaFibra.setForeground(new java.awt.Color(255, 251, 250));

        jButtonSegundaFibra300Mb.setText("300Mb");
        jButtonSegundaFibra300Mb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSegundaFibra300MbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSegundaFibraLayout = new javax.swing.GroupLayout(jPanelSegundaFibra);
        jPanelSegundaFibra.setLayout(jPanelSegundaFibraLayout);
        jPanelSegundaFibraLayout.setHorizontalGroup(
            jPanelSegundaFibraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSegundaFibraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSegundaFibra300Mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSegundaFibraLayout.setVerticalGroup(
            jPanelSegundaFibraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSegundaFibraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSegundaFibra300Mb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelTV.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TV", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelTV.setForeground(new java.awt.Color(255, 251, 250));

        jButtonEligeTV.setText("Elige TV");
        jButtonEligeTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEligeTVActionPerformed(evt);
            }
        });

        jButtonEligeTVPremium.setText("Elige TV Premium");
        jButtonEligeTVPremium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEligeTVPremiumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTVLayout = new javax.swing.GroupLayout(jPanelTV);
        jPanelTV.setLayout(jPanelTVLayout);
        jPanelTVLayout.setHorizontalGroup(
            jPanelTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEligeTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEligeTVPremium, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jPanelTVLayout.setVerticalGroup(
            jPanelTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonEligeTV, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEligeTVPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanelFijo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFijo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fijo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelFijo.setForeground(new java.awt.Color(255, 251, 250));

        jButtonFijo100min.setText("100min");
        jButtonFijo100min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFijo100minActionPerformed(evt);
            }
        });

        jButtonFijoIlimitadas.setText("Ilimitadas");
        jButtonFijoIlimitadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFijoIlimitadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFijoLayout = new javax.swing.GroupLayout(jPanelFijo);
        jPanelFijo.setLayout(jPanelFijoLayout);
        jPanelFijoLayout.setHorizontalGroup(
            jPanelFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFijoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFijo100min, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFijoIlimitadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFijoLayout.setVerticalGroup(
            jPanelFijoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFijoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonFijo100min, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonFijoIlimitadas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanelMovil.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Móvil", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelMovil.setForeground(new java.awt.Color(255, 251, 250));

        jButton10GB.setText("10GB");
        jButton10GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10GBActionPerformed(evt);
            }
        });

        jButton30GB.setText("30GB");
        jButton30GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30GBActionPerformed(evt);
            }
        });

        jButton75GB.setText("75GB");
        jButton75GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75GBActionPerformed(evt);
            }
        });

        jButton150GB.setText("150GB");
        jButton150GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton150GBActionPerformed(evt);
            }
        });

        jButtonIlimitados.setText("Ilimitados");
        jButtonIlimitados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIlimitadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMovilLayout = new javax.swing.GroupLayout(jPanelMovil);
        jPanelMovil.setLayout(jPanelMovilLayout);
        jPanelMovilLayout.setHorizontalGroup(
            jPanelMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton75GB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton150GB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIlimitados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMovilLayout.setVerticalGroup(
            jPanelMovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMovilLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton10GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton30GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton75GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton150GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIlimitados, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFibra.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFibra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fibra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanelFibra.setForeground(new java.awt.Color(255, 251, 250));

        jButtonFibra300Mb.setText("300Mb");
        jButtonFibra300Mb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFibra300MbActionPerformed(evt);
            }
        });

        jButtonFibra600Mb.setText("600Mb");
        jButtonFibra600Mb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFibra600MbActionPerformed(evt);
            }
        });

        jButtonFibra1GB.setText("1GB");
        jButtonFibra1GB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFibra1GBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFibraLayout = new javax.swing.GroupLayout(jPanelFibra);
        jPanelFibra.setLayout(jPanelFibraLayout);
        jPanelFibraLayout.setHorizontalGroup(
            jPanelFibraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFibraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFibraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFibra300Mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFibra600Mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFibra1GB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFibraLayout.setVerticalGroup(
            jPanelFibraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFibraLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonFibra300Mb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFibra600Mb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFibra1GB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFactura.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Compañía:");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_Black.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jTable1);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Comparativa Precio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldPrecioActual.setText("000.00");
        jTextFieldPrecioActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioActualActionPerformed(evt);
            }
        });

        jLabel1.setText("Precio Actual:");

        jLabel2.setText("Precio Tarifa:");

        jLabel3.setText("Ahorro Mensual:");

        jTextFieldPrecioTarifa.setText("000.00");
        jTextFieldPrecioTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecioTarifaActionPerformed(evt);
            }
        });

        jTextFieldAhorroTotal.setText("000.00");
        jTextFieldAhorroTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAhorroTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAhorroTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrecioTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrecioTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAhorroTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButtonEliminarCeldas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jButtonEliminarCeldas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCeldasActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Calle Ardigales Nº15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(214, 214, 214))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(19, 19, 19))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compania.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/telefono.png"))); // NOI18N

        javax.swing.GroupLayout jPanelFacturaLayout = new javax.swing.GroupLayout(jPanelFactura);
        jPanelFactura.setLayout(jPanelFacturaLayout);
        jPanelFacturaLayout.setHorizontalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCompania, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFacturaLayout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelFacturaLayout.createSequentialGroup()
                        .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEliminarCeldas)
                            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 45, Short.MAX_VALUE))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFacturaLayout.setVerticalGroup(
            jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacturaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarCeldas)
                .addGap(69, 69, 69)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jButtonImprimir.setBackground(new java.awt.Color(255, 251, 250));
        jButtonImprimir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf50x20.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(jPanelMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jPanelFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFibraMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelAdicionales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFibra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSegundaFibra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonImprimir)
                .addGap(282, 282, 282))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelFibraMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanelMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelTV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelFijo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jPanelAdicionales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelFibra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelSegundaFibra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanelFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        try {
            // Obtener una instancia de PrinterJob
            PrinterJob printerJob = PrinterJob.getPrinterJob();

            // Establecer el objeto Printable para el trabajo de impresión
            printerJob.setPrintable(new Printable() {
                @Override
                public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
                    // Si se solicita una página diferente a la primera, devolver NO_SUCH_PAGE
                    if (pageIndex != 0) {
                        return NO_SUCH_PAGE;
                    }

                    // Configurar el formato de la página
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                    g2d.scale(pageFormat.getImageableWidth() / jPanelFactura.getWidth(),
                        pageFormat.getImageableHeight() / jPanelFactura.getHeight());

                    // Imprimir el panel
                    jPanelFactura.paint(g2d);
                    return PAGE_EXISTS;
                }
            });

            // Mostrar el diálogo de impresión y, si el usuario acepta, imprimir
            if (printerJob.printDialog()) {
                printerJob.print();
            }
        } catch (PrinterException e) { // Imprimir el rastro de la pila para depuración
            JOptionPane.showMessageDialog(null, "Error al imprimir: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jTextFieldAhorroTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAhorroTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAhorroTotalActionPerformed

    private void jTextFieldPrecioTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioTarifaActionPerformed

    }//GEN-LAST:event_jTextFieldPrecioTarifaActionPerformed

    private void jTextFieldPrecioActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecioActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecioActualActionPerformed

    private void jButtonEliminarCeldasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCeldasActionPerformed
        eliminarCelda();
    }//GEN-LAST:event_jButtonEliminarCeldasActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed

    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonFibra1GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFibra1GBActionPerformed
        insertarInformacionTabla("Fibra 1GB",27.90);
    }//GEN-LAST:event_jButtonFibra1GBActionPerformed

    private void jButtonFibra600MbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFibra600MbActionPerformed
        insertarInformacionTabla("Fibra 600Mb",22.90);
    }//GEN-LAST:event_jButtonFibra600MbActionPerformed

    private void jButtonFibra300MbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFibra300MbActionPerformed
        insertarInformacionTabla("Fibra 300Mb",17.90);
    }//GEN-LAST:event_jButtonFibra300MbActionPerformed

    private void jButtonIlimitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIlimitadosActionPerformed
        insertarInformacionTabla("Móvil GB Ilimitados",19.90);
    }//GEN-LAST:event_jButtonIlimitadosActionPerformed

    private void jButton150GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton150GBActionPerformed
        insertarInformacionTabla("Móvil 150GB",14.90);
    }//GEN-LAST:event_jButton150GBActionPerformed

    private void jButton75GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75GBActionPerformed
        insertarInformacionTabla("Móvil 75GB",11.90);
    }//GEN-LAST:event_jButton75GBActionPerformed

    private void jButton30GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30GBActionPerformed
        insertarInformacionTabla("Móvil 30GB",8.90);
    }//GEN-LAST:event_jButton30GBActionPerformed

    private void jButton10GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10GBActionPerformed
        insertarInformacionTabla("Móvil 10GB",5.90);
    }//GEN-LAST:event_jButton10GBActionPerformed

    private void jButtonFijoIlimitadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFijoIlimitadasActionPerformed
        insertarInformacionTabla("Fijo Ilimitadas",11.90);
    }//GEN-LAST:event_jButtonFijoIlimitadasActionPerformed

    private void jButtonFijo100minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFijo100minActionPerformed
        insertarInformacionTabla("Fijo 100min",9.90);
    }//GEN-LAST:event_jButtonFijo100minActionPerformed

    private void jButtonEligeTVPremiumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEligeTVPremiumActionPerformed
        insertarInformacionTabla("Elige TV Premium",11.90);
    }//GEN-LAST:event_jButtonEligeTVPremiumActionPerformed

    private void jButtonEligeTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEligeTVActionPerformed
        insertarInformacionTabla("Elige TV",6.90);
    }//GEN-LAST:event_jButtonEligeTVActionPerformed

    private void jButtonSegundaFibra300MbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSegundaFibra300MbActionPerformed
        insertarInformacionTabla("Segunda Fibra 300Mb",14.90);
    }//GEN-LAST:event_jButtonSegundaFibra300MbActionPerformed

    private void jButtonAdicional150GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicional150GBActionPerformed
        insertarInformacionTabla("Adicional 150GB",12.90);
    }//GEN-LAST:event_jButtonAdicional150GBActionPerformed

    private void jButtonAdicional75GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicional75GBActionPerformed
        insertarInformacionTabla("Adicional 75GB",9.90);
    }//GEN-LAST:event_jButtonAdicional75GBActionPerformed

    private void jButtonAdicional20GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicional20GBActionPerformed
        insertarInformacionTabla("Adicional 20GB",4.90);
    }//GEN-LAST:event_jButtonAdicional20GBActionPerformed

    private void jButtonAdicional5GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicional5GBActionPerformed
        insertarInformacionTabla("Adicional 5GB",2.90);
    }//GEN-LAST:event_jButtonAdicional5GBActionPerformed

    private void jButton1GBIlimitadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GBIlimitadosActionPerformed
        insertarInformacionTabla("Fibra 1GB + Ilimitados",34.90);
    }//GEN-LAST:event_jButton1GBIlimitadosActionPerformed

    private void jButton1GB150GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1GB150GBActionPerformed
        insertarInformacionTabla("Fibra 1GB + 150GB",29.90);
    }//GEN-LAST:event_jButton1GB150GBActionPerformed

    private void jButton600Mb55GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton600Mb55GBActionPerformed
        insertarInformacionTabla("Fibra 600Mb + 55GB",25.90);
    }//GEN-LAST:event_jButton600Mb55GBActionPerformed

    private void jButton600Mb10GBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton600Mb10GBActionPerformed
        insertarInformacionTabla("Fibra 600Mb + 10GB",18.90);
    }//GEN-LAST:event_jButton600Mb10GBActionPerformed


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(PresupuestosFinetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresupuestosFinetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresupuestosFinetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresupuestosFinetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PresupuestosFinetwork().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton jButton10GB;
    private javax.swing.JButton jButton150GB;
    private javax.swing.JButton jButton1GB150GB;
    private javax.swing.JButton jButton1GBIlimitados;
    private javax.swing.JButton jButton30GB;
    private javax.swing.JButton jButton600Mb10GB;
    private javax.swing.JButton jButton600Mb55GB;
    private javax.swing.JButton jButton75GB;
    private javax.swing.JButton jButtonAdicional150GB;
    private javax.swing.JButton jButtonAdicional20GB;
    private javax.swing.JButton jButtonAdicional5GB;
    private javax.swing.JButton jButtonAdicional75GB;
    private javax.swing.JButton jButtonEligeTV;
    private javax.swing.JButton jButtonEligeTVPremium;
    private javax.swing.JButton jButtonEliminarCeldas;
    private javax.swing.JButton jButtonFibra1GB;
    private javax.swing.JButton jButtonFibra300Mb;
    private javax.swing.JButton jButtonFibra600Mb;
    private javax.swing.JButton jButtonFijo100min;
    private javax.swing.JButton jButtonFijoIlimitadas;
    private javax.swing.JButton jButtonIlimitados;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonSegundaFibra300Mb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanelAdicionales;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JPanel jPanelFibra;
    private javax.swing.JPanel jPanelFibraMovil;
    private javax.swing.JPanel jPanelFijo;
    private javax.swing.JPanel jPanelMovil;
    private javax.swing.JPanel jPanelSegundaFibra;
    private javax.swing.JPanel jPanelTV;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAhorroTotal;
    private javax.swing.JTextField jTextFieldCompania;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecioActual;
    private javax.swing.JTextField jTextFieldPrecioTarifa;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
