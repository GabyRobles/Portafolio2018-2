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
using MaterialSkin;
using MaterialSkin.Controls;

namespace LoginUsuario
{
    public partial class PanelPrincipal : MaterialForm
    {
        //atributos
        int posicion;
        Login login;
       
       //String de Conexion con AWS de Amazon
        OracleConnection ora = new OracleConnection("DATA SOURCE=aura.cckolbo3d8nz.us-east-1.rds.amazonaws.com:1521/Auradb;USER ID=ADMAURA;PASSWORD= admin123");

        public PanelPrincipal()
        {
            InitializeComponent();
            //Cambiar los valores de colores del materil skin
            MaterialSkinManager m = MaterialSkinManager.Instance;
            m.AddFormToManage(this);
            m.Theme = MaterialSkinManager.Themes.LIGHT;
            m.ColorScheme = new ColorScheme(Primary.Amber400, Primary.Amber500, Primary.Amber200,Accent.Green100,TextShade.BLACK);

        }
        //seleccionarToda_Encargado
        private void PanelPrincipal_Load(object sender, EventArgs e)
        {
                                   
            //carga de las grillas
            CargarCeldas(dgvProducto);
            CargarGerente(dgvAsociacion);
            CargarSucursal(dgvSucursal);
            CargarEncargado(dgvEncargado);
            //metodos de carga de combobox
            CargarComboBox(cbocategoria);
            CargarComboEmpresaSuc(cboEmpresaSuc);
            CargarComboGAsocPuesto(cbopuestoGA);
            CargarComboENPuesto(cboPuestoEN);
            CargarComboBoxEmpAG(cboEmADM);
            CargarComboBoxEmpEN(cboEmpresaEN);

        }
        public void CargarCeldas(DataGridView dgv)//se cargan los pruductos en la grilla 
        {
            try
            {

                ora.Open();//se abre la conexion
                OracleCommand comando = new OracleCommand("seleccionarToda_Producto", ora);//se llama el procedimiento y la conexion
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgv.DataSource = tabla;
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
                ora.Close();
            }

        }
        public void CargarGerente(DataGridView dgv)//metodo que carga la grilla de Gerente de asociacion
        {
            try
            {

                ora.Open();
                OracleCommand comando = new OracleCommand("seleccionarToda_Gerente", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgv.DataSource = tabla;
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
                ora.Close();
            }

        }
        public void CargarSucursal(DataGridView dgv)//metodo que carga la grilla de sucursal
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("seleccionarToda_Sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgv.DataSource = tabla;
                ora.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
            }
        }
        public void CargarEncargado(DataGridView dgv)//metodo que carga la grilla de encargdo de local
        {
            try
            {

                ora.Open();
                OracleCommand comando = new OracleCommand("seleccionarToda_Encargado", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgv.DataSource = tabla;
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
                ora.Close();
            }

        }


        private void btnCerrarSession_Click(object sender, EventArgs e)//boton de cerrar session
        {
            ora.Close();//cierra la conexion con la bd
            login = new Login();//crea un nuevo login
            login.Show();//nos direcciona al login
            this.Close();//cierra el fromulario Principal
        }

        public void CargarComboBoxEmpEN(ComboBox cbo)//se carga el combo box de empresas encargado
        {
            try
            {
                ora.Open();//abrimos la conexion
                OracleDataAdapter da = new OracleDataAdapter("select * from empresa", ora);//hacemos una consula en la db y lo capturamos en el da que es un adaptador
                DataTable dt = new DataTable();//guardamos en un objeto de datatable lo encontrado
                da.Fill(dt);//el adaptadr esta cargado en el data table

                if (dt.Rows.Count > 0)//si lo que esta en la dt o datatable es mayor a 0
                {
                    cboEmpresaEN.DataSource = dt;//cargara el cbocategoria con la dt de table
                    cboEmpresaEN.DisplayMember = "nombre";//lo que nos mostrara en el combobox
                    cboEmpresaEN.ValueMember = "id_empresa"; //los nombre los asociara al id de cada nombre
                }
                ora.Close();//se cierra la conexion
            }
            catch (Exception ex)
            {

                throw;
            }
        }
        public void CargarComboBoxEmpAG(ComboBox cbo)//se carga el combo box de empresas Gerente asociacion
        {
            try
            {
                ora.Open();//abrimos la conexion
                OracleDataAdapter da = new OracleDataAdapter("select * from empresa where id_empresa= 1", ora);//hacemos una consula en la db y lo capturamos en el da que es un adaptador
                DataTable dt = new DataTable();//guardamos en un objeto de datatable lo encontrado
                da.Fill(dt);//el adaptadr esta cargado en el data table

                if (dt.Rows.Count > 0)//si lo que esta en la dt o datatable es mayor a 0
                {
                    cboEmADM.DataSource = dt;//cargara el cbocategoria con la dt de table
                    cboEmADM.DisplayMember = "nombre";//lo que nos mostrara en el combobox
                    cboEmADM.ValueMember = "id_empresa"; //los nombre los asociara al id de cada nombre
                }
                ora.Close();//se cierra la conexion
            }
            catch (Exception ex)
            {

                throw;
            }
        }


        public void CargarComboBox(ComboBox cbo)//se carga el combo box de categoria de productos
        {
            try
            {
                ora.Open();//abrimos la conexion
                OracleDataAdapter da = new OracleDataAdapter("select * from categoria", ora);//hacemos una consula en la db y lo capturamos en el da que es un adaptador
                DataTable dt = new DataTable();//guardamos en un objeto de datatable lo encontrado
                da.Fill(dt);//el adaptadr esta cargado en el data table

                if (dt.Rows.Count > 0)//si lo que esta en la dt o datatable es mayor a 0
                {
                    cbocategoria.DataSource = dt;//cargara el cbocategoria con la dt de table
                    cbocategoria.DisplayMember = "nombre";//lo que nos mostrara en el combobox
                    cbocategoria.ValueMember = "id_categoria"; //los nombre los asociara al id de cada nombre
                }
                ora.Close();//se cierra la conexion
            }
            catch (Exception ex)
            {

                throw;
            }
           


        }
        public void CargarComboEmpresaSuc(ComboBox cbo)//Carga el combo box de Empresas de Sucursal
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from Empresa", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cboEmpresaSuc.DataSource = dt;
                    cboEmpresaSuc.DisplayMember = "nombre";
                    cboEmpresaSuc.ValueMember = "id_empresa";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                throw;
            }
        }
             public void CargarComboGAsocPuesto(ComboBox cbo)//carga los puesto de gerente de asociacion
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from puesto where id_puesto= 1", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cbopuestoGA.DataSource = dt;
                    cbopuestoGA.DisplayMember = "puesto";
                    cbopuestoGA.ValueMember = "id_puesto";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                throw;
            }

        }
        public void CargarComboENPuesto(ComboBox cbo)//carga los puesto de encargado de local
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from puesto where id_puesto= 3", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cboPuestoEN.DataSource = dt;
                    cboPuestoEN.DisplayMember = "puesto";
                    cboPuestoEN.ValueMember = "id_puesto";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                throw;
            }

        }

        private void btnNuevoProducto_Click(object sender, EventArgs e)
        {

        }



        private void btnSucursal_Click(object sender, EventArgs e)//boton de actualizar 
        {
            try
            {

                if (txtNomsucu.Text.Equals("") && txtDiresucu.Equals(""))//verifica que los txxbox esten llenos
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");//mensaje al usuario
                }
                else
                {
                    //capturamos el valor del combobox
                    int idempresa = Convert.ToInt32(cboEmpresaSuc.SelectedValue.ToString());

                    ora.Open();
                    OracleCommand comando = new OracleCommand("Insertar_sucursal", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNomsucu.Text;
                    comando.Parameters.Add("direccion", OracleType.VarChar).Value = txtDiresucu.Text;
                    comando.Parameters.Add("idsc", OracleType.VarChar).Value = idempresa;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido Insertado");
                    ora.Close();
                }
                this.CargarSucursal(dgvSucursal);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha siddo Insertado el registro");
                ora.Close();
            }
        }

        private void btnNuevoEncargado_Click(object sender, EventArgs e) {//boton de  nuevo
            try
            {
                //INSERTAR_TRABAJADOR(nombre in VARCHAR2,crro in VARCHAR2,pss in VARCHAR2,idp in number,idemp in NUMBER)
                if (txtNomsucu.Text.Equals("") && txtDiresucu.Equals(""))//verifica que los txxbox esten llenos
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");//mensaje al usuario
                }
                else
                {

                    //capturar los valores de los combobox
                    int idpuesto = Convert.ToInt32(cboPuestoEN.SelectedValue.ToString());
                    int idempresa = Convert.ToInt32(cboPuestoEN.SelectedValue.ToString());
                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_TRABAJADOR", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;

                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNomsucu.Text;
                    comando.Parameters.Add("crro", OracleType.VarChar).Value = txtDiresucu.Text;
                    comando.Parameters.Add("pss", OracleType.VarChar).Value = txtDiresucu.Text;
                    comando.Parameters.Add("idp", OracleType.VarChar).Value = idpuesto;
                    comando.Parameters.Add("idemp", OracleType.VarChar).Value = idempresa;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido insertado");
                    ora.Close();
                }
                this.CargarSucursal(dgvSucursal);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha sido insertado el registro");
                ora.Close();
            }
        }



        private void button1_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtNomsucu.Text.Equals("")&&txtDiresucu.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {
                    ora.Open();
                    OracleCommand comando = new OracleCommand("actualizar_sucursal", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idsuc", OracleType.Number).Value = Convert.ToInt32(txtIdsucu.Text);
                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtNomsucu.Text;
                    comando.Parameters.Add("dir", OracleType.VarChar).Value = txtDiresucu.Text;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido Actualizado");
                    ora.Close();
                }
                this.CargarSucursal(dgvSucursal);
              }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Actualizado el registro");
                ora.Close();
            }
        }



        private void btnBuscarSucursal_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtSucursal.Text);
                    if (comando.Parameters != null)
                    {
                        comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                        comando.ExecuteNonQuery();
                        OracleDataAdapter adaptador = new OracleDataAdapter();
                        adaptador.SelectCommand = comando;
                        DataTable tabla = new DataTable();
                        adaptador.Fill(tabla);
                        dgvSucursal.DataSource = tabla;
                        ora.Close();
                }


             }
            catch (Exception ex)
            {

                MessageBox.Show("Dato no encontrado");
                OracleCommand comando = new OracleCommand("seleccionarToda_Sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando = new OracleCommand("seleccionarToda_Sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgvSucursal.DataSource = tabla;
                ora.Close();
            }
            
        }

        private void dgvSucursal_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            posicion = dgvSucursal.CurrentRow.Index;
            txtIdsucu.Text = dgvSucursal[0, posicion].Value.ToString();
            txtNomsucu.Text = dgvSucursal[1, posicion].Value.ToString();
            txtDiresucu.Text = dgvSucursal[2, posicion].Value.ToString();
            cboEmpresaSuc.Text=dgvSucursal[3, posicion].Value.ToString();
            
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            try
            {
                    ora.Open();
                    OracleCommand comando = new OracleCommand("eliminar_sucursal", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idsuc", OracleType.Number).Value = Convert.ToInt32(txtIdsucu.Text);
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido Eliminado");
                    ora.Close();
               
                this.CargarSucursal(dgvSucursal);
                txtDiresucu.Clear();
                txtNomsucu.Clear();
                txtIdsucu.Clear();
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Eliminado el registro");
            }
        }


        private void cboEmpresa_SelectedIndexChanged(object sender, EventArgs e)
        {
            ora.Open();
            string query = "select upper(NOMBRE)from EMPRESA where ID_EMPRESA > 1; ";
            OracleCommand comando = new OracleCommand(query, ora);
            comando.CommandType = CommandType.Text;
            OracleDataAdapter adp = new OracleDataAdapter(comando);
            DataSet ds = new DataSet();
            adp.Fill(ds);
            ora.Close();
        }


        private void dgvAsociacion_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            posicion = dgvAsociacion.CurrentRow.Index;
            txtidAG.Text = dgvAsociacion[0, posicion].Value.ToString();
            txtnomAG.Text = dgvAsociacion[1, posicion].Value.ToString();
            txtcorrAG.Text = dgvAsociacion[2, posicion].Value.ToString();
            txtcontAG.Text = dgvAsociacion[3, posicion].Value.ToString();
            cbopuestoGA.Text = dgvAsociacion[4, posicion].Value.ToString();
            cboEmADM.Text = dgvAsociacion[5, posicion].Value.ToString();
        }

        private void btnBuscaGerente_Click(object sender, EventArgs e)
        {
            //seleccionar_Gerente
            try
            {
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Gerente", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtidAG.Text);
                if (comando.Parameters != null)
                {
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dgvAsociacion.DataSource = tabla;
                    ora.Close();
                }


            }
            catch (Exception ex)
            {

                CargarGerente(dgvAsociacion);
            }
        }

        private void btnelimGA_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_trabajador", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidAG.Text);
                comando.ExecuteNonQuery();
                MessageBox.Show("El Archivo ha sido Eliminado");
                ora.Close();

                this.CargarSucursal(dgvSucursal);
                txtidAG.Clear();
                txtnomAG.Clear();
                txtcorrAG.Clear();
               
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Eliminado el registro");
            }
        }

        private void btnmodiGA_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtnomAG.Text.Equals("") && txtcorrAG.Equals("") && txtcontAG.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {
                    // idtra in number, nom in VARCHAR2, cor in VARCHAR2, pass in VARCHAR2
                    ora.Open();
                    OracleCommand comando = new OracleCommand("actualizar_trabajador", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidAG.Text);
                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtnomAG.Text;
                    comando.Parameters.Add("cor", OracleType.VarChar).Value = txtcorrAG.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtcontAG.Text;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido Actualizado");
                    ora.Close();
                }
                this.CargarGerente(dgvAsociacion);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Actualizado el registro");
            }
        }

        private void dgvEncargado_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            posicion = dgvEncargado.CurrentRow.Index;
            txtidEC.Text = dgvEncargado[0, posicion].Value.ToString();
            txtnomEC.Text = dgvEncargado[1, posicion].Value.ToString();
            txtcorrEC.Text = dgvEncargado[2, posicion].Value.ToString();
            txtpsEC.Text = dgvEncargado[3, posicion].Value.ToString();
            cboPuestoEN.Text = dgvEncargado[4, posicion].Value.ToString();
            cboEmpresaEN.Text = dgvEncargado[5, posicion].Value.ToString();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            //CargarEncargado(dgvEncargado);
            try
            {

                if (txtnomEC.Text.Equals("") && txtnomEC.Equals("") && txtcorrEC.Equals("") && txtpsEC.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {
                    // idtra in number, nom in VARCHAR2, cor in VARCHAR2, pass in VARCHAR2
                    ora.Open();
                    OracleCommand comando = new OracleCommand("actualizar_trabajador", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidEC.Text);
                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtnomEC.Text;
                    comando.Parameters.Add("cor", OracleType.VarChar).Value = txtcorrEC.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtpsEC.Text;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido Actualizado");
                    ora.Close();
                }
                this.CargarEncargado(dgvEncargado);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Actualizado el registro");
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_trabajador", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidEC.Text);
                comando.ExecuteNonQuery();
                MessageBox.Show("El Archivo ha sido Eliminado");
                ora.Close();

                this.CargarSucursal(dgvSucursal);
                txtidEC.Clear();
                txtnomEC.Clear();
                txtcorrEC.Clear();
                txtpsEC.Clear();
             
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Eliminado el registro");
            }
        }

        private void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();

                OracleCommand comando = new OracleCommand("SELECCIONAR_PRODUCTO", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idsu", OracleType.Number).Value = Convert.ToInt32(txtbuscarPro.Text);
                if (comando.Parameters != null)
                {
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dgvProducto.DataSource = tabla;
                    ora.Close();
                }


            }
            catch (Exception ex)
            {
                MessageBox.Show("Dato no encontrado");
                OracleCommand comando = new OracleCommand("seleccionarToda_producto", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando = new OracleCommand("seleccionarToda_producto", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgvProducto.DataSource = tabla;
                ora.Close();
            }
        }

        private void btnBuscarEncargado_Click(object sender, EventArgs e)
        {
            //seleccionar_Gerente
            try
            {
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Encargado", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtbuscarencar.Text);
                if (comando.Parameters != null)
                {
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dgvEncargado.DataSource = tabla;
                    ora.Close();
                }
                this.CargarEncargado(dgvEncargado);

            }
            catch (Exception ex)
            {

                this.CargarEncargado(dgvEncargado);
            }
        }

        private void btnGerente_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtnomAG.Text.Equals("") && txtcorrAG.Equals("") && txtcontAG.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {//"INSERTAR_TRABAJADOR" (nombre in VARCHAR2,crro in VARCHAR2,pss in VARCHAR2,idp in number,idemp in NUMBER)
                    // nombre,crro,pss,idp,idemp
                    ora.Open();
                    //capturamos el valor del combobox
                    int idempresa = Convert.ToInt32(cboEmADM.SelectedValue.ToString());
                    int idpu = Convert.ToInt32(cbopuestoGA.SelectedValue.ToString());
                    OracleCommand comando = new OracleCommand("INSERTAR_TRABAJADOR", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                   comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtnomAG.Text;
                    comando.Parameters.Add("crro", OracleType.VarChar).Value = txtcorrAG.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtcontAG.Text;
                    comando.Parameters.Add("idp", OracleType.Number).Value = idempresa;
                    comando.Parameters.Add("idemp", OracleType.Number).Value = idpu;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido insertado");
                    ora.Close();

                }
                this.CargarGerente(dgvAsociacion);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha insertado el registro");
            }
            
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtnomPro.Text.Equals("") && txtprecioPro.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {//capturamos el combobox
                    int idcate = Convert.ToInt32(cbocategoria.SelectedValue.ToString());

                    //"INSERTAR_PRODUCTO"(nombre in VARCHAR2, prec in number, fecelb in date, fechven in date, idcat in number)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_PRODUCTO", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                                        comando.Parameters.Add("nombre", OracleType.VarChar).Value =txtnomAG.Text;
                    comando.Parameters.Add("prec", OracleType.VarChar).Value = Convert.ToInt32(txtprecioPro.Text.ToString());
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtcontAG.Text;
                    comando.Parameters.Add("fecelb", OracleType.Number).Value = dtpElaboPr.Text;
                    comando.Parameters.Add("fechven", OracleType.Number).Value = dtpvecipro.Text;
                    comando.Parameters.Add("idcat", OracleType.Number).Value = idcate;
                    comando.ExecuteNonQuery();
                    MessageBox.Show("El Archivo ha sido insertado");
                    ora.Close();

                }
                this.CargarGerente(dgvAsociacion);
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha insertado el registro");
            }
        }

        private void button1_Click_1(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)//eliminar producto
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_producto", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtidpro.Text);
                comando.ExecuteNonQuery();
                MessageBox.Show("El Archivo ha sido Eliminado");
                ora.Close();

                this.CargarCeldas(dgvProducto);
                txtidpro.Clear();
                txtnomPro.Clear();
                txtprecioPro.Clear(); 

            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha Eliminado el registro");
                this.CargarCeldas(dgvProducto);
            }
        }

        private void dgvProducto_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

            posicion = dgvProducto.CurrentRow.Index;
            txtidpro.Text = dgvProducto[0, posicion].Value.ToString();
            txtnomPro.Text = dgvProducto[1, posicion].Value.ToString();
            txtprecioPro.Text = dgvProducto[2, posicion].Value.ToString();

            DateTime curDate;
            if (DateTime.TryParse(dgvProducto[3, posicion].Value.ToString(), out curDate))
            {
                dtpElaboPr.Value = curDate;
            }
            DateTime curDates;
            if (DateTime.TryParse(dgvProducto[4, posicion].Value.ToString(), out curDates))
            {
                dtpvecipro.Value = curDates;
            }

            cbocategoria.Text = dgvProducto[5, posicion].Value.ToString();
        }
    }


}
