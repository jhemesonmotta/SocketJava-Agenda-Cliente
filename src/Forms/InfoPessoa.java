package Forms;

//import Classes.MyThread;
import Classes.Mensagem;
import Classes.Pessoa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class InfoPessoa extends javax.swing.JFrame {
    ArrayList<Pessoa> pessoas = new ArrayList();
    Socket cSocket=null;  //socket do cliente
    ObjectOutputStream envia = null; //objeto para mandar msg pro servidor
    ObjectInputStream recebe = null; //objeto para ler msgs vindas do servidor  
    
    public InfoPessoa() {
        initComponents();
        diretoNoCodigo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfIdade = new javax.swing.JTextField();
        rbFeminino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        rbNaoSabe = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        btnInserir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        labelHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Idade:");

        jLabel3.setText("Sexo:");

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");

        buttonGroup1.add(rbMasculino);
        rbMasculino.setText("Masculino");

        buttonGroup1.add(rbNaoSabe);
        rbNaoSabe.setText("Não Sabe");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jScrollPane1.setViewportView(taDescricao);

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        labelHora.setText("Hora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfIdade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMasculino)
                            .addComponent(rbNaoSabe)
                            .addComponent(rbFeminino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnInserir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(rbFeminino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMasculino)
                    .addComponent(labelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbNaoSabe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnPesquisar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        try {
            cSocket = new Socket("127.0.0.1",7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        int idade = Integer.parseInt(tfIdade.getText());
        String nome = tfNome.getText();
        String sexo = "";
        if(rbFeminino.isSelected()){
            sexo = "Feminino";
        }
        else if(rbMasculino.isSelected()){
            sexo = "Masculino";
        }
        else{
            sexo = "Indefinido";
        }

        Pessoa novoHumano = new Pessoa(nome, idade, sexo);
        Mensagem msg = new Mensagem(novoHumano, "Inserir");
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Deu ruim, meu paladino");
            }
            else{
                limpar();
                taDescricao.setText("Sucesso, meu patrão");
            }
            envia.close();
            recebe.close();
            cSocket.close();
        } catch (Exception e) {//se maq desabilitada ou erro de leitura/escrita
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            cSocket = new Socket("127.0.0.1",7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        Pessoa p = new Pessoa();
        p.setNome(nome);
        Mensagem msg = new Mensagem(p, "Excluir");
        
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            System.out.println(resp.getAcao());
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Deu ruim, meu paladino");
            }
            else{
                taDescricao.setText("Sucesso, meu patrão");
                limpar();
            }
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            cSocket = new Socket("127.0.0.1",7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        Pessoa p = new Pessoa();
        p.setNome(nome);
        Mensagem msg = new Mensagem(p, "Pesquisar");
        try {
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            InputStream iptStream = cSocket.getInputStream();
            recebe = new ObjectInputStream(iptStream);
            Mensagem resp = (Mensagem) recebe.readObject();
            
            try{
                if(resp.getAcao().contains("Erro")){
                    taDescricao.setText("Deu ruim, meu paladino");
                }
                else{
                    System.err.println("Aqui1 ");
                    System.err.println("Aqui: " + resp.getPessoa().toString());
                    taDescricao.setText("Sucesso, meu patrão");
                    tfNome.setText(resp.getPessoa().getNome());
                    tfIdade.setText(resp.getPessoa().getIdade() + "");
                    rbFeminino.setSelected(resp.getPessoa().getSexo().equalsIgnoreCase("Feminino"));
                    rbMasculino.setSelected(resp.getPessoa().getSexo().equalsIgnoreCase("Masculino"));
                    rbNaoSabe.setSelected(resp.getPessoa().getSexo().equalsIgnoreCase("Indefinido"));
                }
            }
            catch(Exception ex){
                System.err.println("Erro 1 = "+ex);
            }
            
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
        // aqui chama o server
            // tfIdade.setText(RETORNO.getIdade()+"");
            //if(RETORNO.getSexo().equalsIgnoreCase("Feminino")){
//                    rbFeminino.setSelected(true);
//                }
//                else if(RETORNO.getSexo().equalsIgnoreCase("Masculino")){
//                    rbMasculino.setSelected(true);
//                }
//                else{
//                    rbNaoSabe.setSelected(true);
//                }
//taDescricao.setText(p.toString());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            cSocket = new Socket("127.0.0.1",7000);
        } catch (IOException ex) {
            Logger.getLogger(InfoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String nome = tfNome.getText();
        System.out.println("Aqui 1");
        int idade = Integer.parseInt(tfIdade.getText());
        String sexo = "";
        if(rbFeminino.isSelected()){
            sexo = "Feminino";
        }
        else if(rbMasculino.isSelected()){
            sexo = "Masculino";
        }
        else{
            sexo = "Indefinido";
        }
        Pessoa p = new Pessoa(nome,idade,sexo);
        Mensagem msg = new Mensagem(p, "Alterar");
        
        try {              
            envia = new ObjectOutputStream(cSocket.getOutputStream());
            envia.writeObject(msg);
            recebe = new ObjectInputStream(cSocket.getInputStream());
            Mensagem resp = (Mensagem) recebe.readObject();
            System.out.println(resp.getAcao());
            
            if(resp.getAcao().contains("Erro")){
                taDescricao.setText("Deu ruim, meu paladino");
            }
            else{
                taDescricao.setText("Sucesso, meu patrão");
                limpar();
            }
            envia.close();
            recebe.close();
            cSocket.close();
            
        } catch (Exception e) {
            System.err.println("Erro = "+e);
            System.exit(0);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoPessoa().setVisible(true);
            }
        });
    }
    
    public void limpar(){
        tfIdade.setText("");
        tfNome.setText("");
        rbFeminino.setSelected(false);
        rbMasculino.setSelected(false);
        rbNaoSabe.setSelected(false);
        taDescricao.setText("");
    }
    
    public void diretoNoCodigo(){
        MyThread t1 = new MyThread("1", 1);
        t1.start();
        System.out.println(MyThread.currentThread());
        labelHora.setText("hora");
        
        
    }
    
    class MyThread extends Thread{
    DateFormat dateFormat = null;
    Date date = null;
    String time;
    int delay;
    String name;
    public MyThread(String name,  int delay){
        this.delay = delay;
        this.name = name;
    }
    
    public void run() {
        for(int j=0;j<100;j++) {   
            for (int i=0; i<999999999; i++){
                try{
                    sleep(delay);
                }
                catch(InterruptedException e){
                    continue;
                }
                labelHora.setText(this.getTime());
            }
        }
    }
    
    public String getTime(){
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
        time = dateFormat.format(date);
        return this.time;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHora;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JRadioButton rbNaoSabe;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}