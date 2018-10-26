using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OracleClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;//para manejar hilos

namespace LoginUsuario
{
    public partial class FormularioSucursal : Form
    {
        Thread proceso;
        OracleConnection ora = new OracleConnection("DATA SOURCE= xe; PASSWORD= oracle; USER id=ADMAURA;");
        PanelPrincipal pannel;

        public FormularioSucursal()
        {
            InitializeComponent();
        }

        private void FormularioSucursal_Load(object sender, EventArgs e)
        {
            CheckForIllegalCrossThreadCalls = false;//para q no se caiga el hilo
            ora.Open();
            cboEmpresa.Items.Clear();
            proceso = new Thread(new ThreadStart(actualizar));
            proceso.Start();
        }
        public void actualizar() {

            try
            {
                cboEmpresa.Refresh();
                cboEmpresa.Text = "Elegir una Empresa";
                Thread.Sleep(11000);//actualiza en 11 segundos
                cboEmpresa.Items.Clear();//limpiamos el comboBox
                OracleCommand comand = new OracleCommand("select DISTINCT C.NOMBRE AS EMPRES from sUCURSAL p JOIN eMPRESA c ON p.ID_EMPRESA = c.ID_EMPRESA ORDER BY C.NOMBRE;", ora);
                OracleDataReader orc = comand.ExecuteReader();
                while (orc.Read())
                {
                    cboEmpresa.Refresh();
                    cboEmpresa.Items.Add(orc.GetValue(0).ToString());//se llena el combo box
                    
                }

            }
            catch (Exception ex)
            {

                MessageBox.Show(ex.Message);
            }
        }
        private void label1_Click(object sender, EventArgs e)
        {

        }
        private void textBox1_TextChanged (  object sender, EventArgs e)
        {

        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            ora.Close();
            pannel = new PanelPrincipal();
            pannel.Show();
            this.Hide();

        }

        private void btnIngresar_Click(object sender, EventArgs e)
        {
            ora.Open();
            OracleCommand comando = new OracleCommand();
        }
    }
}
