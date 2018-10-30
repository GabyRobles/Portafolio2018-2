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
using System.IO;
using System.Text.RegularExpressions;

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
            m.ColorScheme = new ColorScheme(Primary.Blue600, Primary.Blue500, Primary.Blue400, Accent.Green100, TextShade.WHITE);
        }

        //seleccionarToda_Encargado
        private void PanelPrincipal_Load(object sender, EventArgs e)
        {

            txtidpro.Enabled = false;
            txtidEC.Enabled = false;
            txtIdsucu.Enabled = false;
            txtidAG.Enabled = false;
            txtIdOferta.Enabled = false;

            //carga de las grillas
            CargarCeldas(dgvProducto);
            CargarGerente(dgvAsociacion);
            CargarSucursal(dgvSucursal);
            CargarEncargado(dgvEncargado);
            cargarClienteDataGrid(dtvCliente);
            CargarPuesto(dgvPuesto);
            
            //metodos de carga de combobox
            CargarComboBox(cbocategoria);
            CargarComboEmpresaSuc(cboEmpresaSuc);
            CargarComboGAsocPuesto(cbopuestoGA);
            CargarComboENPuesto(cboPuestoEN);
            CargarComboBoxEmpAG(cboEmADM);
            CargarComboBoxEmpEN(cboEmpresaEN);
            //cargarCboCliente(cboEnvioOfertaCliente);
            CargarOferta(dgvOferta);
            CargarComboOfertaTrabajador(cbotrabajadorOferta);
            CargarComboOfertaSucursal(cboSucOfert);
            CargarComboOfertaProducto(cboprodOfert);
            CargarComboOfertaCategoria(cbocateOfert);
            //validacion de fechas
            dtpElaboPr.MinDate = new DateTime(1985, 6, 20);
            dtpElaboPr.MaxDate = DateTime.Today;
            //dtpvecipro
            dtpvecipro.MinDate = DateTime.Today;//
            dtpvecipro.MaxDate = new DateTime(2100, 6, 20);
            // dtpDesde
            dtpDesde.MaxDate = DateTime.Today;//
            dtpDesde.MinDate = new DateTime(1985, 6, 20);
            //dtpHasta
            dtpHasta.MinDate = DateTime.Today;//
            dtpHasta.MaxDate = new DateTime(2050, 6, 20);
        }

        private Boolean validarCorreo(String email)//validar formato de correo
        {
            String expresion;
            expresion = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";//formato de correo
            if (Regex.IsMatch(email, expresion))
            {
                if (Regex.Replace(email, expresion, String.Empty).Length == 0)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        private void CargarPuesto(DataGridView dgvPuesto)
        {
            try
            {

                ora.Open();//se abre la conexion
                OracleCommand comando = new OracleCommand("seleccionarToda_Puesto", ora);//se llama el procedimiento y la conexion
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dgvPuesto.DataSource = tabla;
                ora.Close();

            }
            catch (Exception ex)
            {

                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
                ora.Close();
            }

        }
        public void CargarOferta(DataGridView dgv)//metodo que carga la grilla de oferta
        {
            try
            {

                ora.Open();
                OracleCommand comando = new OracleCommand("seleccionarToda_Oferta", ora);
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

        //acá arreglar para que filtre
        public void cargarCboCliente(ComboBox cboClienteLocal) {
            try
            {
                ora.Open();//abrimos la conexion
                OracleDataAdapter da = new OracleDataAdapter("select * from consumidor ", ora);//hacemos una consula en la db y lo capturamos en el da que es un adaptador
                DataTable dt = new DataTable();//guardamos en un objeto de datatable lo encontrado
                da.Fill(dt);//el adaptadr esta cargado en el data table

                if (dt.Rows.Count > 0)//si lo que esta en la dt o datatable es mayor a 0
                {
                    cboEnvioOfertaCliente.DataSource = dt;//cargara el cbocategoria con la dt de table
                    cboEnvioOfertaCliente.DisplayMember = "Envío";//lo que nos mostrara en el combobox
                    cboEnvioOfertaCliente.ValueMember = "env_oferta"; //los nombre los asociara al id de cada nombre
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


        private void btnSucursal_Click(object sender, EventArgs e)//boton de actualizar 
        {
            try
            {
                //capturamos el valor del combobox
                int idempresa = Convert.ToInt32(cboEmpresaSuc.SelectedValue.ToString());

                if (txtNomsucu.Text.Equals("") && txtDiresucu.Equals(""))//verifica que los txxbox esten llenos
                {
                    MessageBox.Show("Todos los datos son obligatorios", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {

                    //"INSERTAR_SUCURSAL" (nombre in VARCHAR2,direccion in VARCHAR2,idsc in number)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_SUCURSAL", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNomsucu.Text;
                    comando.Parameters.Add("direccion", OracleType.VarChar).Value = txtDiresucu.Text;
                    comando.Parameters.Add("idsc", OracleType.Number).Value = idempresa;
                    DialogResult resul = MessageBox.Show("¿Seguro que quiere agregar el registro?", "Agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        this.CargarSucursal(dgvSucursal);
                    }
                    else
                    {
                        txtNomsucu.Clear();
                        txtDiresucu.Clear();
                        ora.Close();
                        this.CargarSucursal(dgvSucursal);
                    }

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("No ha sido insertado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarSucursal(dgvSucursal);

            }
        }

        private void btnNuevoEncargado_Click(object sender, EventArgs e) {//boton de  nuevo
            try
            {
                //INSERTAR_TRABAJADOR(nombre in VARCHAR2,crro in VARCHAR2,pss in VARCHAR2,idp in number,idemp in NUMBER)
                if (txtNomsucu.Text.Equals("") && txtDiresucu.Equals(""))//verifica que los txxbox esten llenos
                {
                    MessageBox.Show("Todos los datos son obligatorios", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {

                    //capturar los valores de los combobox

                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_TRABAJADOR", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;

                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtnomEC.Text;
                    comando.Parameters.Add("crro", OracleType.VarChar).Value = txtcorrEC.Text;
                    comando.Parameters.Add("pss", OracleType.VarChar).Value = txtpsEC.Text;
                    int idpuesto = Convert.ToInt32(cboPuestoEN.SelectedValue.ToString());
                    int idempresa = Convert.ToInt32(cboPuestoEN.SelectedValue.ToString());
                    comando.Parameters.Add("idp", OracleType.Number).Value = idpuesto;
                    comando.Parameters.Add("idemp", OracleType.Number).Value = idempresa;
                    DialogResult resul = MessageBox.Show("¿Seguro que quiere agregar el registro?", "Agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido Agregado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarEncargado(dgvEncargado);
                        txtnomEC.Clear();
                        txtcorrEC.Clear();
                        txtpsEC.Clear();
                    }
                    else
                    {
                        txtnomEC.Clear();
                        txtcorrEC.Clear();
                        txtpsEC.Clear();
                        this.CargarEncargado(dgvEncargado);
                    }

                }

            }
            catch (Exception)
            {
                MessageBox.Show("No ha sido insertado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarEncargado(dgvEncargado); ora.Close();

            }
        }



        private void button1_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtNomsucu.Text.Equals("") && txtDiresucu.Equals(""))
                {
                    MessageBox.Show("Todos los datos son obligatorios", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                }
                else
                {
                    //  "ACTUALIZAR_SUCURSAL" (idsuc in INTEGER, nom in VARCHAR2, dir in VARCHAR2) 
                    ora.Open();
                    OracleCommand comando = new OracleCommand("ACTUALIZAR_SUCURSAL", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idsuc", OracleType.Number).Value = Convert.ToInt32(txtIdsucu.Text);
                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtNomsucu.Text;
                    comando.Parameters.Add("dir", OracleType.VarChar).Value = txtDiresucu.Text;
                    DialogResult resul = MessageBox.Show("¿Seguro que quiere modificar el registro?", "Modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("Se elimino el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        txtIdsucu.Clear();
                        txtNomsucu.Clear();
                        txtDiresucu.Clear();
                        this.CargarSucursal(dgvSucursal);
                    }
                    else
                    {
                        this.CargarSucursal(dgvSucursal);
                        ora.Close();
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("No se ha actualizado el registro");
                this.CargarSucursal(dgvSucursal);
                ora.Close();
            }
        }

        private void btnBuscarSucursal_Click(object sender, EventArgs e)
        {
            try
            {
                //seleccionar_Sucursal (idsu in number,registros out sys_refcursor) 
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idsu", OracleType.Number).Value = Convert.ToInt32(txtSucursal.Text);
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
                this.CargarSucursal(dgvSucursal);

            }

        }

        private void dgvSucursal_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            posicion = dgvSucursal.CurrentRow.Index;
            txtIdsucu.Text = dgvSucursal[0, posicion].Value.ToString();
            txtNomsucu.Text = dgvSucursal[1, posicion].Value.ToString();
            txtDiresucu.Text = dgvSucursal[2, posicion].Value.ToString();
            cboEmpresaSuc.Text = dgvSucursal[3, posicion].Value.ToString();

        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_sucursal", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idsuc", OracleType.Number).Value = Convert.ToInt32(txtIdsucu.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "Eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El archivo ha sido eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.CargarSucursal(dgvSucursal);
                    txtDiresucu.Clear();
                    txtNomsucu.Clear();
                    txtIdsucu.Clear();
                }
                else
                {
                    ora.Close();
                    this.CargarSucursal(dgvSucursal);
                }

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha eliminado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                this.CargarSucursal(dgvSucursal);
                ora.Close();
            }
        }


        private void cboEmpresa_SelectedIndexChanged(object sender, EventArgs e)
        {
            ora.Open();
            string query = "select upper(NOMBRE)from EMPRESA where ID_EMPRESA = 1; ";
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
                //seleccionar_Gerente(idge in number, registros out sys_refcursor)
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Gerente", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtbuscargeente.Text);
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
                DialogResult resul = MessageBox.Show("¿Seguro que quiere eliminar el registro?", "modificar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El archivo ha sido eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.CargarSucursal(dgvSucursal);
                }
                else
                {
                    this.CargarSucursal(dgvSucursal);
                    txtidAG.Clear();
                    txtnomAG.Clear();
                    txtcorrAG.Clear();
                }

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha eliminado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarSucursal(dgvSucursal);
            }
        }

        private void btnmodiGA_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtnomAG.Text.Equals("") && txtcorrAG.Equals("") && txtcontAG.Equals(""))
                {
                    MessageBox.Show("Todos los datos Son obligatorios", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
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
                    DialogResult resul = MessageBox.Show("¿Seguro que quiere modificar el registro?", "modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El archivo ha sido actualizado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarGerente(dgvAsociacion);
                    }
                    else
                    {
                        txtnomAG.Clear();
                        txtcontAG.Clear();
                        txtcorrAG.Clear();
                        this.CargarGerente(dgvAsociacion);
                        ora.Close();
                    }
                }

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha actualizado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                CargarGerente(dgvAsociacion);
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
                    //"ACTUALIZAR_TRABAJADOR" ( idtra in number, nom in VARCHAR2, cor in VARCHAR2, pass in VARCHAR2)
                    // idtra in number, nom in VARCHAR2, cor in VARCHAR2, pass in VARCHAR2
                    ora.Open();
                    OracleCommand comando = new OracleCommand("ACTUALIZAR_TRABAJADOR", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidEC.Text);
                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtnomEC.Text;
                    comando.Parameters.Add("cor", OracleType.VarChar).Value = txtcorrEC.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtpsEC.Text;
                    DialogResult resul = MessageBox.Show("¿Seguro que quiere Modificar el Registro?", "Modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El archivo ha sido modificado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarEncargado(dgvEncargado);
                        txtnomEC.Clear();
                        txtcorrEC.Clear();
                        txtpsEC.Clear();
                    }
                    else
                    {
                        txtnomEC.Clear();
                        txtcorrEC.Clear();
                        txtpsEC.Clear();
                        this.CargarEncargado(dgvEncargado);
                    }
                }
            } catch (Exception)
            {
                MessageBox.Show("No se ha Actualizado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarEncargado(dgvEncargado);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            try
            {//  "ELIMINAR_TRABAJADOR" (idtra in number)

                ora.Open();
                OracleCommand comando = new OracleCommand("ELIMINAR_TRABAJADOR", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idtra", OracleType.Number).Value = Convert.ToInt32(txtidEC.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El Archivo ha sido eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.CargarEncargado(dgvEncargado);
                    txtnomEC.Clear();
                    txtcorrEC.Clear();
                    txtpsEC.Clear();
                }
                else
                {
                    txtnomEC.Clear();
                    txtcorrEC.Clear();
                    txtpsEC.Clear();
                    this.CargarEncargado(dgvEncargado);
                }
            
            }catch (Exception)
            {
                MessageBox.Show("No se ha eliminado el registro","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                this.CargarEncargado(dgvEncargado);
    }
    }


        private void btnBuscarProducto_Click(object sender, EventArgs e)
        {
            try
            {
                //seleccionar_Producto (idge in number,registros out sys_refcursor) 
                ora.Open();

                OracleCommand comando = new OracleCommand("SELECCIONAR_PRODUCTO", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtbuscarPro.Text);
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
            catch (Exception)
            {
                MessageBox.Show("Dato no encontrado");
                this.CargarCeldas(dgvProducto);
            }
        }

        private void btnBuscarEncargado_Click(object sender, EventArgs e)
        {
            //seleccionar_Gerente
            try
            {
                //seleccionar_Encargado (idge in number,registros out sys_refcursor)
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
                

            }
            catch (Exception)
            {
                MessageBox.Show("Dato no encontrado");
                this.CargarEncargado(dgvEncargado);
            }
        }

        private void btnGerente_Click(object sender, EventArgs e)
        {
            try
            { 

                if (txtnomAG.Text.Equals("") && txtcorrAG.Equals("") && txtcontAG.Equals(""))
                {
                    MessageBox.Show("Todos los datos son obligatorios","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                }
                else
                {//"INSERTAR_TRABAJADOR" (nombre in VARCHAR2,crro in VARCHAR2,pss in VARCHAR2,idp in number,idemp in NUMBER)
                 // nombre,crro,pss,idp,idemp

                    //capturamos el valor del combobox

                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_TRABAJADOR", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;

                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtnomAG.Text;
                    comando.Parameters.Add("crro", OracleType.VarChar).Value = txtcorrAG.Text;
                    comando.Parameters.Add("pss", OracleType.VarChar).Value = txtcontAG.Text;
                    int idpuesto = Convert.ToInt32(cbopuestoGA.SelectedValue.ToString());
                    int idempresa = Convert.ToInt32(cboEmADM.SelectedValue.ToString());
                    comando.Parameters.Add("idp", OracleType.Number).Value = idpuesto;
                    comando.Parameters.Add("idemp", OracleType.Number).Value = idempresa;
                    DialogResult resul = MessageBox.Show("Seguro que quiere agregar el Registro?", "Agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El archivo ha sido insertado","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                        txtnomAG.Clear();
                        txtcorrAG.Clear();
                        txtcontAG.Clear();
                        this.CargarGerente(dgvAsociacion);
                    }
                    else
                    {
                        txtNomsucu.Clear();
                        txtDiresucu.Clear();
                        this.CargarGerente(dgvAsociacion);
                        ora.Close();
                    }
                    
                }
             
            }
            catch (Exception)
            {
                MessageBox.Show("No se ha insertado el registro","titulo",MessageBoxButtons.OK,MessageBoxIcon.Warning);
                ora.Close();
                CargarGerente(dgvAsociacion);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                if (txtnomPro.Text.Equals(""))
                {
                    MessageBox.Show("Inserte Mensaje", "Dato incompleto", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else if (txtprecioPro.Equals(""))
                {
                    MessageBox.Show("Inserte Mensaje", "Dato incompleto", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
               else if (txtnomPro.Text.Equals("") && txtprecioPro.Equals(""))
                {
                    MessageBox.Show("Inserte Mensaje", "Faltan datos", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else
                {//capturamos el combobox
                    int idcate = Convert.ToInt32(cbocategoria.SelectedValue.ToString());

                    //"INSERTAR_PRODUCTO"(nombre in VARCHAR2, prec in number, fecelb in date, fechven in date, idcat in number)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_PRODUCTO", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value =txtnomPro.Text;
                    comando.Parameters.Add("prec", OracleType.Number).Value = Convert.ToInt32(txtprecioPro.Text.ToString());
                    comando.Parameters.Add("fecelb", OracleType.DateTime).Value = dtpElaboPr.Text;
                    comando.Parameters.Add("fechven", OracleType.DateTime).Value = dtpvecipro.Text;
                    comando.Parameters.Add("idcat", OracleType.Number).Value = idcate;
                    DialogResult resul = MessageBox.Show("Seguro que quiere agregar el Registro?", "Agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                    MessageBox.Show("Inserte Mensaje", "Correcto", MessageBoxButtons.YesNo, MessageBoxIcon.Information);
                        this.CargarCeldas(dgvProducto);
                    }
                    else
                    {
                        txtnomPro.Clear();
                        txtprecioPro.Clear();
                        ora.Close();
                        this.CargarCeldas(dgvProducto);
                    }
                    }
            }
            catch (Exception)
            {
                MessageBox.Show("Inserte Mensaje", "Error", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarCeldas(dgvProducto);
            }
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            try
            {
                if (txtnomPro.Text.Equals(""))//mensaje que editar
                {
                    MessageBox.Show("Inserte Mensaje", "Dato incompleto", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else if (txtprecioPro.Equals(""))
                {
                    MessageBox.Show("Inserte Mensaje", "Dato incompleto", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }

                else if (txtnomPro.Text.Equals("") && txtprecioPro.Equals(""))
                {
                    MessageBox.Show("Inserte Mensaje", "Dato incompleto", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                }
                else
                {

                    //"ACTUALIZAR_PRODUCTO"(ID_PRODUCTO in NUMBER, NOMBRE in VARCHAR2, PRECIO in NUMBER, FECHA_ELAB in DATE, FECHA_VEN in DATE, ID_CATEGORIA in NUMBER)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("ACTUALIZAR_PRODUCTO", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("ID_PRODUCTOS", OracleType.VarChar).Value = Convert.ToInt32(txtidpro.Text);
                    comando.Parameters.Add("NOM", OracleType.VarChar).Value = txtnomPro.Text;
                    comando.Parameters.Add("PREC", OracleType.Number).Value = Convert.ToInt32(txtprecioPro.Text.ToString());
                    comando.Parameters.Add("FECHA_EL", OracleType.DateTime).Value = dtpElaboPr.Text;
                    comando.Parameters.Add("FECHA_VE", OracleType.DateTime).Value = dtpvecipro.Text;
                    //capturamos el combobox
                    int idcate = Convert.ToInt32(cbocategoria.SelectedValue.ToString());
                    comando.Parameters.Add("ID_CATE", OracleType.Number).Value = idcate;

                    DialogResult resul = MessageBox.Show("Seguro que quiere modificar el Registro?", "Modificar Registro", MessageBoxButtons.YesNo,MessageBoxIcon.Information );
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                    }
                    else
                    {
                        txtnomPro.Clear();
                        txtprecioPro.Clear();
                        ora.Close();
                    }

                }
                this.CargarCeldas(dgvProducto);

            }
            catch (Exception)
            {
                MessageBox.Show("Inserte Mensaje", "No Actualizado", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button2_Click(object sender, EventArgs e)//eliminar producto
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_producto", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtidpro.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "Eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El Archivo ha sido Eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Information);

                }
                else
                {
                    txtidpro.Clear();
                    txtnomPro.Clear();
                    txtprecioPro.Clear();
                    ora.Close();
                }

                this.CargarCeldas(dgvProducto);


            }
            catch (Exception )
            {
                MessageBox.Show("No se ha Eliminado el registro","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                this.CargarCeldas(dgvProducto);
            }
        }

        private void dgvProducto_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

            posicion = dgvProducto.CurrentRow.Index;
            txtidpro.Text = dgvProducto[0, posicion].Value.ToString();
            txtnomPro.Text = dgvProducto[1, posicion].Value.ToString();
            txtprecioPro.Text = dgvProducto[2, posicion].Value.ToString();

            DateTime curDatess;
            if (DateTime.TryParse(dgvProducto[3, posicion].Value.ToString(), out curDatess))
            {
                dtpElaboPr.Value = curDatess;
            }
            DateTime curDatees;
            if (DateTime.TryParse(dgvProducto[4, posicion].Value.ToString(), out curDatees))
            {
                dtpvecipro.Value = curDatees;
            }

            cbocategoria.Text = dgvProducto[5, posicion].Value.ToString();
        }


        //cargar los datos de la grilla.
        private void dtvCliente_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {


            posicion = dtvCliente.CurrentRow.Index;
            txtIdCliente.Text = dtvCliente[0, posicion].Value.ToString();
            txtNombreCliente.Text = dtvCliente[1, posicion].Value.ToString();
            txtApellidoCliente.Text = dtvCliente[2, posicion].Value.ToString();
            txtRutCliente.Text = dtvCliente[3, posicion].Value.ToString();
            txtCorreoCliente.Text = dtvCliente[5, posicion].Value.ToString();
            txtContrasenaCliente.Text = dtvCliente[6, posicion].Value.ToString();
            txtPuntajeCliente.Text = dtvCliente[7, posicion].Value.ToString();
            txtTelefono.Text = dtvCliente[8, posicion].Value.ToString();
            
            DateTime curDate;
            if (DateTime.TryParse(dtvCliente[4, posicion].Value.ToString(), out curDate))
            {
                dtNacimientoCliente.Value = curDate;
            }
            

            cboEnvioOfertaCliente.Text = dtvCliente[9, posicion].Value.ToString();
        }

        public void cargarClienteDataGrid(DataGridView dto) {
            try
            {

                ora.Open();//se abre la conexion
                OracleCommand comando = new OracleCommand("seleccionarToda_CONSUMIDOR", ora);//se llama el procedimiento y la conexion
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                OracleDataAdapter adaptador = new OracleDataAdapter();
                adaptador.SelectCommand = comando;
                DataTable tabla = new DataTable();
                adaptador.Fill(tabla);
                dtvCliente.DataSource = tabla;
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("No se Pudo Cargar las Celdas" + ex.ToString());
                ora.Close();
            }


        }

        private void btnBuscarCliente_Click(object sender, EventArgs e)
        {
            try
            {//seleccionar_Consumidor (idge in number,registros out sys_refcursor) 
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_Consumidor", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtBuscarCliente.Text);
                if (comando.Parameters != null)
                {
                    MessageBox.Show("Consumidor encontrado");
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dtvCliente.DataSource = tabla;
                    ora.Close();
                }


            }
            catch (Exception )
            {

                MessageBox.Show("Dato no encontrado");
                this.cargarClienteDataGrid(dtvCliente);
            }
        }

        private void btnNuevoCliente_Click(object sender, EventArgs e)
        {
            //CargarEncargado(dgvEncargado);
            try
            {

                if (txtNombreCliente.Text.Equals("") && txtApellidoCliente.Equals("") && txtRutCliente.Equals("") && txtCorreoCliente.Equals("") && txtContrasenaCliente.Equals("") && txtPuntajeCliente.Equals("") && txtTelefono.Equals(""))
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                }
                else
                {
                    // "INSERTAR_CONSUMIDOR" (nombre in VARCHAR2,ape in VARCHAR2,rut in VARCHAR2,fechnac in date,correo in VARCHAR2,pass in VARCHAR2, 
                    //pto in NUMBER,tele in VARCHAR2,envofe in CHAR)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("insertar_consumidor", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNombreCliente.Text;
                    comando.Parameters.Add("ape", OracleType.VarChar).Value = txtApellidoCliente.Text;
                    comando.Parameters.Add("rut", OracleType.VarChar).Value = txtRutCliente.Text;
                    comando.Parameters.Add("fechnac", OracleType.DateTime).Value = dtNacimientoCliente.Text;
                    comando.Parameters.Add("correo", OracleType.VarChar).Value = txtCorreoCliente.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtContrasenaCliente.Text;
                    comando.Parameters.Add("pto", OracleType.Number).Value = Convert.ToInt32(txtPuntajeCliente.Text);
                    comando.Parameters.Add("tele", OracleType.VarChar).Value = txtTelefono.Text;
                    comando.Parameters.Add("envofe", OracleType.VarChar).Value = cboEnvioOfertaCliente.Text;
                    DialogResult resul = MessageBox.Show("Seguro que quiere agregar el Registro?", "agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido Agregar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.cargarClienteDataGrid(dtvCliente);
                        txtNombreCliente.Clear();
                        txtApellidoCliente.Clear();
                        txtRutCliente.Clear();
                        txtCorreoCliente.Clear();
                        txtContrasenaCliente.Clear();
                        txtPuntajeCliente.Clear();
                        txtTelefono.Clear();
                    }
                    else
                    {
                        this.cargarClienteDataGrid(dtvCliente);
                        txtNombreCliente.Clear();
                        txtApellidoCliente.Clear();
                        txtRutCliente.Clear();
                        txtCorreoCliente.Clear();
                        txtContrasenaCliente.Clear();
                        txtPuntajeCliente.Clear();
                        txtTelefono.Clear();
                        ora.Close();
                    }

                }

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha Actualizado el registro");
                this.cargarClienteDataGrid(dtvCliente);
                txtNombreCliente.Clear();
                txtApellidoCliente.Clear();
                txtRutCliente.Clear();
                txtCorreoCliente.Clear();
                txtContrasenaCliente.Clear();
                txtPuntajeCliente.Clear();
                txtTelefono.Clear();
                ora.Close();
            }
        }

        private void btnModificarCliente_Click(object sender, EventArgs e)
        {
            //CargarEncargado(dgvEncargado);
            try
            {

                if (txtNombreCliente.Text.Equals("") && txtApellidoCliente.Equals("") && txtRutCliente.Equals("") && txtCorreoCliente.Equals("") && txtContrasenaCliente.Equals("") && txtPuntajeCliente.Equals("") && txtTelefono.Equals("") )
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios");
                }
                else
                {
                    // "ACTUALIZAR_CONSUMIDOR" (idpue in NUMBER,nombre in VARCHAR2,ape in VARCHAR2,rut in VARCHAR2,fechnac in date,correo in VARCHAR2,pass in VARCHAR2,
                    //pto in NUMBER,tele in VARCHAR2,envofe in CHAR)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("actualizar_consumidor", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtIdCliente.Text);
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNombreCliente.Text;
                    comando.Parameters.Add("ape", OracleType.VarChar).Value = txtApellidoCliente.Text;
                    comando.Parameters.Add("rut", OracleType.VarChar).Value = txtRutCliente.Text;
                    comando.Parameters.Add("fechnac", OracleType.Number).Value = dtNacimientoCliente.Text;
                    comando.Parameters.Add("correo", OracleType.VarChar).Value = txtCorreoCliente.Text;
                    comando.Parameters.Add("pass", OracleType.VarChar).Value = txtContrasenaCliente.Text;
                    comando.Parameters.Add("pto", OracleType.VarChar).Value = txtPuntajeCliente.Text;
                    comando.Parameters.Add("tele", OracleType.VarChar).Value = txtTelefono.Text;
                    //falta cbo.


                    DialogResult resul = MessageBox.Show("Seguro que quiere modificar el Registro?", "modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido modificar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.cargarClienteDataGrid(dtvCliente);
                        txtNombreCliente.Clear();
                        txtApellidoCliente.Clear();
                        txtRutCliente.Clear();
                        txtCorreoCliente.Clear();
                        txtContrasenaCliente.Clear();
                        txtPuntajeCliente.Clear();
                        txtTelefono.Clear();
                    }
                    else
                    {
                        this.cargarClienteDataGrid(dtvCliente);
                        txtNombreCliente.Clear();
                        txtApellidoCliente.Clear();
                        txtRutCliente.Clear();
                        txtCorreoCliente.Clear();
                        txtContrasenaCliente.Clear();
                        txtPuntajeCliente.Clear();
                        txtTelefono.Clear();
                        ora.Close();
                    }

                }

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha Actualizado el registro");
                this.cargarClienteDataGrid(dtvCliente);
                txtNombreCliente.Clear();
                txtApellidoCliente.Clear();
                txtRutCliente.Clear();
                txtCorreoCliente.Clear();
                txtContrasenaCliente.Clear();
                txtPuntajeCliente.Clear();
                txtTelefono.Clear();
                ora.Close();
            }
        }

        //falta terminar esto, está casi listo
        private void btnEliminarCliente_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("eliminar_consumidor", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtIdCliente.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El Archivo ha sido eliminar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.cargarClienteDataGrid(dtvCliente);
                    txtNombreCliente.Clear();
                    txtApellidoCliente.Clear();
                    txtRutCliente.Clear();
                    txtCorreoCliente.Clear();
                    txtContrasenaCliente.Clear();
                    txtPuntajeCliente.Clear();
                    txtTelefono.Clear();
                }
                else
                {
                    this.cargarClienteDataGrid(dtvCliente);
                    txtNombreCliente.Clear();
                    txtApellidoCliente.Clear();
                    txtRutCliente.Clear();
                    txtCorreoCliente.Clear();
                    txtContrasenaCliente.Clear();
                    txtPuntajeCliente.Clear();
                    txtTelefono.Clear();
                    ora.Close();
                }

            

            }
            catch (Exception)
            {
                MessageBox.Show("No se ha eliminar el registro");
                this.cargarClienteDataGrid(dtvCliente);
                txtNombreCliente.Clear();
                txtApellidoCliente.Clear();
                txtRutCliente.Clear();
                txtCorreoCliente.Clear();
                txtContrasenaCliente.Clear();
                txtPuntajeCliente.Clear();
                txtTelefono.Clear();
                ora.Close();
            }
}



/*---------------------------------------------  Puesto  -------------------------------------------------------*/

        //Muestra la información en el datagrid
        private void dgvPuesto_CellContentClick(object sender, DataGridViewCellEventArgs e) 
        {

            posicion = dgvPuesto.CurrentRow.Index;
            txtPuestoId.Text = dgvPuesto[0, posicion].Value.ToString();
            txtPuestoNombre.Text = dgvPuesto[1, posicion].Value.ToString();
          
        }

        //Crea nuevo puesto
        private void btnNuevoPuesto_Click(object sender, EventArgs e)
        {
            try
            {
                
                if (txtPuestoNombre.Text.Equals(""))//verifica que los textbox esten llenos
                {
                    MessageBox.Show("El dato es obligatorio","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {
                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_PUESTO", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtPuestoNombre.Text;
                    DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido Eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarPuesto(dgvPuesto);
                        txtPuestoNombre.Clear();
                    }
                    else
                    {
                        this.CargarPuesto(dgvPuesto);
                        txtPuestoNombre.Clear();
                    }
                }
               
            }
            catch (Exception )
            {
                MessageBox.Show("No ha sido insertado ningun puesto");
                ora.Close();
                this.CargarPuesto(dgvPuesto);
                txtPuestoNombre.Clear();
            }
        }



        //Modifica Puesto
        private void btnModificarPuesto_Click(object sender, EventArgs e)
        {
            try
            {

                if (txtPuestoNombre.Text.Equals(""))//verifica que los textbox esten llenos
                {
                    MessageBox.Show("El Nuevo nombre es obligatorio","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {// "ACTUALIZAR_PUESTO" (idpue in NUMBER,pue in VARCHAR2)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("ACTUALIZAR_PUESTO", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;
                    comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtPuestoId.Text); 
                    comando.Parameters.Add("pue", OracleType.VarChar).Value = txtPuestoNombre.Text;
                    DialogResult resul = MessageBox.Show("Seguro que quiere modificar el Registro?", "modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido modificar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarPuesto(dgvPuesto);
                        txtPuestoNombre.Clear();
                    }
                    else
                    {
                        this.CargarPuesto(dgvPuesto);
                        txtPuestoNombre.Clear();
                    }
                }

            }
            catch (Exception)
            {
                MessageBox.Show("No ha sido modificar ningun puesto");
                ora.Close();
                this.CargarPuesto(dgvPuesto);
                txtPuestoNombre.Clear();
            }

        }


        /*Eliminar Puesto*/
        private void btnEliminarPuesto_Click(object sender, EventArgs e)
        {
            try
            {
                //"ELIMINAR_PUESTO" (idpue in NUMBER)
                ora.Open();
                OracleCommand comando = new OracleCommand("ELIMINAR_PUESTO", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtPuestoId.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El Archivo ha sido Eliminado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.CargarPuesto(dgvPuesto);
                    txtPuestoNombre.Clear();
                }
                else
                {
                    this.CargarPuesto(dgvPuesto);
                    txtPuestoNombre.Clear();
                }
            


            }
            catch (Exception )
            {
                MessageBox.Show("No ha sido eliminado ningun puesto");
                ora.Close();
                this.CargarPuesto(dgvPuesto);
        txtPuestoNombre.Clear();
            }
}

        private void btnGenerarBI_Click(object sender, EventArgs e)
        {   
            ora.Open();
            OracleDataAdapter consulta = new OracleDataAdapter("select cont_correos,cont_consumidor,cont_oferta,cont_cupones from registro where fecha >= to_date('" + dtpDesde.Value.ToString("dd/MM/yy").Replace('-', '/') + "', 'DD/MM/YY') and fecha < to_date('" + dtpHasta.Value.ToString("dd/MM/yy").Replace('-', '/') + "', 'DD/MM/YY')", ora);
           // OracleDataAdapter consulta = new OracleDataAdapter("select cont_correos,cont_consumidor,cont_oferta,cont_cupones from registro", ora);
            DataTable dt = new DataTable();//guardamos en un objeto de datatable lo encontrado
            consulta.Fill(dt);
            string dataFiller = string.Empty;
            StreamWriter archivotxt = new StreamWriter("C:\\Users\\solita\\Desktop\\ejemplo.txt");
            foreach (DataRow item in dt.Rows)
            {
                foreach (decimal registro in item.ItemArray)
                {
                    dataFiller = dataFiller + registro.ToString() + ";";
                }
                archivotxt.WriteLine(dataFiller);
                dataFiller = string.Empty;
            }
            archivotxt.Close();
            ora.Close();
        }

        private void btnBuscarOferta_Click(object sender, EventArgs e)
        {
            try
            {//buscar Oferta
                ora.Open();

                OracleCommand comando = new OracleCommand("SELECCIONAR_OFERTA", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idofe", OracleType.Number).Value = Convert.ToInt32(txtBuscarOferta.Text);
                if (comando.Parameters != null)
                {
                    
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dgvOferta.DataSource = tabla;
                    ora.Close();
                    MessageBox.Show("Oferta encontrada");
                }


            }
            catch (Exception )
            {

                MessageBox.Show("Dato no encontrado");
                this.CargarOferta(dgvOferta);
                ora.Close();
            }
        }
        //nueva oferta
        private void btnNuevaOferta_Click(object sender, EventArgs e)
        {

            //"INSERTAR_OFERTA" (nombre in VARCHAR2,tpo in VARCHAR2,img in VARCHAR2,prof in NUMBER,idtr in NUMBER,idsuc in NUMBER,idproin in number,fechini in date,fechater in date,idcat in number)
            try
            {
                if (txtNombreOferta.Text.Equals("") && txtTipoOferta.Equals("") && txtUrlOferta.Equals("") && txtPrecioOferta.Equals("")
                    && dtpFechaIni.Equals("")
                    && dtpFechaTer.Equals(""))//verifica que los txt esten llenos
                {
                    MessageBox.Show("Todos los Datos Son Obligatorios","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {
                    // "INSERTAR_OFERTA" (nombre in VARCHAR2,tpo in VARCHAR2,img in VARCHAR2,prof in NUMBER,idtr in NUMBER,idsuc in NUMBER,idproin in NUMBER,fechini in DATE,fechater in DATE,idcat in NUMBER)

                    ora.Open();
                    OracleCommand comando = new OracleCommand("INSERTAR_OFERTA", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;

                    comando.Parameters.Add("nom", OracleType.VarChar).Value = txtNombreOferta.Text;
                    comando.Parameters.Add("tpo", OracleType.VarChar).Value = txtTipoOferta.Text;
                    comando.Parameters.Add("img", OracleType.VarChar).Value = txtUrlOferta.Text;
                    comando.Parameters.Add("prof", OracleType.Number).Value = Convert.ToInt32(txtPrecioOferta.Text);
                    int idcate = Convert.ToInt32(cbocateOfert.SelectedValue.ToString());
                    int idprod = Convert.ToInt32(cboprodOfert.SelectedValue.ToString());
                    int idtraba = Convert.ToInt32(cbotrabajadorOferta.SelectedValue.ToString());
                    int idsuc = Convert.ToInt32(cboSucOfert.SelectedValue.ToString());
                    comando.Parameters.Add("idtr", OracleType.Number).Value = idtraba;
                    comando.Parameters.Add("idsuc", OracleType.Number).Value = idsuc;
                    comando.Parameters.Add("idproin", OracleType.Number).Value = idprod;
                    comando.Parameters.Add("fechini", OracleType.DateTime).Value = dtpFechaIni.Text;
                    comando.Parameters.Add("fechater", OracleType.DateTime).Value = dtpFechaTer.Text;
                    comando.Parameters.Add("idcat", OracleType.Number).Value = idcate;
                    DialogResult resul = MessageBox.Show("Seguro que quiere agregar el Registro?", "agregar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido agregar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarOferta(dgvOferta);
                        txtNombreOferta.Clear();
                        txtTipoOferta.Clear();
                        txtUrlOferta.Clear();
                    }
                    else
                    {
                        this.CargarOferta(dgvOferta);
                        txtNombreOferta.Clear();
                        txtTipoOferta.Clear();
                        txtUrlOferta.Clear();
                    }

                }
            }
            catch (Exception )
            {
                MessageBox.Show("No se ha sido insertado el registro","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                this.CargarOferta(dgvOferta);
                txtNombreOferta.Clear();
                txtTipoOferta.Clear();
                txtUrlOferta.Clear();
                ora.Close();
            }
        }
        
        //modificar oferta
        private void btnModificarOferta_Click_1(object sender, EventArgs e)
        {
            int idcate = Convert.ToInt32(cbocateOfert.SelectedValue.ToString());
            int idprod = Convert.ToInt32(cboprodOfert.SelectedValue.ToString());
            int idtraba = Convert.ToInt32(cbotrabajadorOferta.SelectedValue.ToString());
            int idsuc = Convert.ToInt32(cboSucOfert.SelectedValue.ToString());

            try
            {
                if (txtIdOferta.Text.Equals("") && txtNombreOferta.Text.Equals("") && txtTipoOferta.Equals("") && txtUrlOferta.Equals("")
                    && txtPrecioOferta.Equals("")
                    && dtpFechaIni.Equals("") && dtpFechaTer.Equals(""))//verifica que los txt esten llenos
                {


                    MessageBox.Show("Todos los Datos Son Obligatorios","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);//mensaje al usuario
                }
                else
                {
                    // "ACTUALIZAR_OFERTA" (idpue in NUMBER,nombre in VARCHAR2,tpo in VARCHAR2,img in VARCHAR2,prof in NUMBER,idtr in NUMBER,idsuc in NUMBER,idproin in number,fechini in date,fechater in date,idcat in number)
                    ora.Open();
                    OracleCommand comando = new OracleCommand("ACTUALIZAR_OFERTA", ora);
                    comando.CommandType = System.Data.CommandType.StoredProcedure;

                    comando.Parameters.Add("idpue", OracleType.Number).Value = Convert.ToInt32(txtIdOferta.Text);
                    comando.Parameters.Add("nombre", OracleType.VarChar).Value = txtNombreOferta.Text;
                    comando.Parameters.Add("tpo", OracleType.VarChar).Value = txtTipoOferta.Text;
                    comando.Parameters.Add("img", OracleType.VarChar).Value = txtUrlOferta.Text;
                    comando.Parameters.Add("prof", OracleType.Number).Value = Convert.ToInt32(txtPrecioOferta.Text);
                    comando.Parameters.Add("idtr", OracleType.Number).Value = idtraba;
                    comando.Parameters.Add("idsuc", OracleType.Number).Value = idsuc;
                    comando.Parameters.Add("idproin", OracleType.Number).Value = idprod;
                    comando.Parameters.Add("fechini", OracleType.DateTime).Value = dtpFechaIni.Text;
                    comando.Parameters.Add("fechater", OracleType.DateTime).Value = dtpFechaTer.Text;
                    comando.Parameters.Add("idcat", OracleType.Number).Value = idcate;
                    DialogResult resul = MessageBox.Show("Seguro que quiere modificar el Registro?", "modificar Registro", MessageBoxButtons.YesNo);
                    if (resul == DialogResult.Yes)
                    {
                        comando.ExecuteNonQuery();
                        ora.Close();
                        MessageBox.Show("El Archivo ha sido modificado", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                        this.CargarOferta(dgvOferta);
                        txtNombreOferta.Clear();
                        txtTipoOferta.Clear();
                        txtUrlOferta.Clear();
                    }
                    else
                    {
                        this.CargarOferta(dgvOferta);
                        txtNombreOferta.Clear();
                        txtTipoOferta.Clear();
                        txtUrlOferta.Clear();
                    }

                }
            }
            catch (Exception)
            {
                MessageBox.Show("No se ha sido modificado el registro", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                this.CargarOferta(dgvOferta);
                txtNombreOferta.Clear();
                txtTipoOferta.Clear();
                txtUrlOferta.Clear();
                ora.Close();
            }
        }
        //eliminar oferta
        private void btnEliminarOferta_Click(object sender, EventArgs e)
        {
            try
            {
                ora.Open();
                OracleCommand comando = new OracleCommand("ELIMINAR_OFERTA", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idofe", OracleType.Number).Value = Convert.ToInt32(txtIdOferta.Text);
                DialogResult resul = MessageBox.Show("Seguro que quiere eliminar el Registro?", "eliminar Registro", MessageBoxButtons.YesNo);
                if (resul == DialogResult.Yes)
                {
                    comando.ExecuteNonQuery();
                    ora.Close();
                    MessageBox.Show("El Archivo ha sido eliminar", "titulo", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    this.CargarOferta(dgvOferta);
                    txtNombreOferta.Clear();
                    txtTipoOferta.Clear();
                    txtUrlOferta.Clear();
                }
                else
                {
                    this.CargarOferta(dgvOferta);
                    txtNombreOferta.Clear();
                    txtTipoOferta.Clear();
                    txtUrlOferta.Clear();
                }

            }catch (Exception )
            {
                MessageBox.Show("No se ha sido eliminar el registro","titulo",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                this.CargarOferta(dgvOferta);
           txtNombreOferta.Clear();
                txtTipoOferta.Clear();
                txtUrlOferta.Clear();
                ora.Close();
            }
}

        private void dgvOferta_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            posicion = dgvOferta.CurrentRow.Index;
          
            txtIdOferta.Text = dgvOferta[0, posicion].Value.ToString();
            txtNombreOferta.Text = dgvOferta[1, posicion].Value.ToString();
            txtTipoOferta.Text = dgvOferta[2, posicion].Value.ToString();
            txtPrecioOferta.Text = dgvOferta[4, posicion].Value.ToString();
            txtUrlOferta.Text= dgvOferta[3, posicion].Value.ToString();
            cbotrabajadorOferta.Text = dgvOferta[5, posicion].Value.ToString();
            cboSucOfert.Text = dgvOferta[6, posicion].Value.ToString();
            cboprodOfert.Text = dgvOferta[7, posicion].Value.ToString();
            cbocateOfert.Text = dgvOferta[10, posicion].Value.ToString();

            DateTime curData;
            if (DateTime.TryParse(dgvOferta[8, posicion].Value.ToString(), out curData))
            {
                dtpFechaIni.Value = curData;
            }

            DateTime curDatas;
            if (DateTime.TryParse(dgvOferta[9, posicion].Value.ToString(), out curDatas))
            {
                dtpFechaTer.Value = curDatas;
            }


        }


        public void CargarComboOfertaTrabajador(ComboBox cbo)//carga los puesto de encargado de local
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from trabajador", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cbotrabajadorOferta.DataSource = dt;
                    cbotrabajadorOferta.DisplayMember = "nombre";
                    cbotrabajadorOferta.ValueMember = "id_trabajador";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("Datos no encontrados" + ex.ToString());
            }

        }

        public void CargarComboOfertaSucursal(ComboBox cbo)//carga los puesto de encargado de local
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from sucursal", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cboSucOfert.DataSource = dt;
                    cboSucOfert.DisplayMember = "nombre";
                    cboSucOfert.ValueMember = "id_sucursal";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("Datos no encontrados" + ex.ToString());
            }

        }



        public void CargarComboOfertaProducto(ComboBox cbo)//carga los puesto de encargado de local
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from producto", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cboprodOfert.DataSource = dt;
                    cboprodOfert.DisplayMember = "nombre";
                    cboprodOfert.ValueMember = "id_producto";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("Datos no encontrados" + ex.ToString());
            }

        }

        public void CargarComboOfertaCategoria(ComboBox cbo)//carga los puesto de encargado de local
        {
            try
            {
                ora.Open();
                OracleDataAdapter da = new OracleDataAdapter("select * from categoria", ora);
                DataTable dt = new DataTable();
                da.Fill(dt);

                if (dt.Rows.Count > 0)
                {
                    cbocateOfert.DataSource = dt;
                    cbocateOfert.DisplayMember = "nombre";
                    cbocateOfert.ValueMember = "id_categoria";
                }
                ora.Close();
            }
            catch (Exception ex)
            {

                MessageBox.Show("Datos no encontrados" + ex.ToString());
            }

        }

        private void btnBuscarPuesto_Click(object sender, EventArgs e)
        {
            try
            {//seleccionar_puesto (idge in number,registros out sys_refcursor) 
                ora.Open();

                OracleCommand comando = new OracleCommand("seleccionar_puesto", ora);
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("idge", OracleType.Number).Value = Convert.ToInt32(txtBuscarPuesto.Text);
                if (comando.Parameters != null)
                {
                    MessageBox.Show("Informacion encontrada");
                    comando.Parameters.Add("registros", OracleType.Cursor).Direction = ParameterDirection.Output;
                    comando.ExecuteNonQuery();
                    OracleDataAdapter adaptador = new OracleDataAdapter();
                    adaptador.SelectCommand = comando;
                    DataTable tabla = new DataTable();
                    adaptador.Fill(tabla);
                    dgvPuesto.DataSource = tabla;
                    ora.Close();
                }


            }
            catch (Exception)
            {

                MessageBox.Show("Dato no encontrado");
                this.CargarPuesto(dgvPuesto);
            }
        }

        private void txtprecioPro_KeyPress(object sender, KeyPressEventArgs e)
        {
            //condición que solo acepte numeros
            if (char.IsDigit(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//no permitira ingresar espacios
            {
                e.Handled = false;
            }
            else if ((e.KeyChar=='.')&&(!txtprecioPro.Text.Contains(".")))//aceptar un decimal
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
                MessageBox.Show("Solo se Admiten numeros", "Validación numeros", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtprecioPro.SelectAll();
                txtprecioPro.Focus();
            }
        }

        private void txtPuntajeCliente_KeyPress(object sender, KeyPressEventArgs e)
        {
            //condición que solo acepte numeros
            if (char.IsDigit(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//no permitira ingresar espacios
            {
                e.Handled = false;
            }
            else if ((e.KeyChar == '.') && (!txtPuntajeCliente.Text.Contains(".")))//aceptar un decimal
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
                MessageBox.Show("Solo se Admiten numeros", "Validación numeros", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtPuntajeCliente.SelectAll();
                txtPuntajeCliente.Focus();
            }
        }

        private void txtPrecioOferta_KeyPress(object sender, KeyPressEventArgs e)
        {
            //condición que solo acepte numeros
            if (char.IsDigit(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//no permitira ingresar espacios
            {
                e.Handled = false;
            }
            else if ((e.KeyChar == '.') && (!txtPrecioOferta.Text.Contains(".")))//aceptar un decimal
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
                MessageBox.Show("Solo se Admiten numeros", "Validación numeros", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtPrecioOferta.SelectAll();
                txtPrecioOferta.Focus();
            }
        }

        private void txtNombreOferta_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres","Validación de palabras",MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
                txtNombreOferta.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
            }
        }

        private void txtnomPro_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtnomPro.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtnomPro.SelectAll();
                txtnomPro.Focus();
            }
        }

        private void txtnomAG_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtnomAG.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtnomAG.SelectAll();
                txtnomAG.Focus();
            }
        }

        private void txtNomsucu_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtNomsucu.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtNomsucu.SelectAll();
                txtNomsucu.Focus();
            }
        }

        private void txtDiresucu_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtDiresucu.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtDiresucu.SelectAll();
                txtDiresucu.Focus();
            }
        }

        private void txtnomEC_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtnomEC.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtnomEC.SelectAll();
                txtnomEC.Focus();
            }
        }

        private void txtNombreCliente_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtNombreCliente.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtNombreCliente.SelectAll();
                txtNombreCliente.Focus();
            }
        }

        private void txtApellidoCliente_KeyPress(object sender, KeyPressEventArgs e)
        {
            //solo permite ingresar datos de tipo texto
            if (char.IsLetter(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//permite utilizar la tecla borrar
            {
                e.Handled = false;
            }
            else if (char.IsSeparator(e.KeyChar))//permite utilizar el espacio
            {
                e.Handled = false;
            }
            else
            {
                MessageBox.Show("Solo se admiten caracteres", "Validación de palabras", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtApellidoCliente.CharacterCasing = CharacterCasing.Upper;//admite mayusculas
                txtApellidoCliente.SelectAll();
                txtApellidoCliente.Focus();
            }
        }

        private void txtCorreoCliente_Leave(object sender, EventArgs e)
        {
            //captura del dato
            if (validarCorreo(txtCorreoCliente.Text))
            {

            }
            else
            {
                MessageBox.Show("Dirección de correo electronico no valida", "el correo debe tener el formato ejemplo@gmail.cl, por favor seleccione un correo valido", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtCorreoCliente.SelectAll();
                txtCorreoCliente.Focus();
            }
        }

        private void txtcorrEC_Leave(object sender, EventArgs e)
        {
            //captura del dato
            if (validarCorreo(txtcorrEC.Text))
            {

            }
            else
            {
                MessageBox.Show("Dirección de correo electronico no valida", "el correo debe tener el formato ejemplo@gmail.cl, por favor seleccione un correo valido", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtcorrEC.SelectAll();
                txtcorrEC.Focus();
            }
        }

        private void txtcorrAG_Leave(object sender, EventArgs e)
        {
            //captura del dato
            if (validarCorreo(txtcorrAG.Text))
            {

            }
            else
            {
                MessageBox.Show("Dirección de correo electronico no valida", "el correo debe tener el formato ejemplo@gmail.cl, por favor seleccione un correo valido", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtcorrAG.SelectAll();
                txtcorrAG.Focus();
            }
        }

        private void txtTelefono_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (char.IsDigit(e.KeyChar))
            {
                e.Handled = false;
            }
            else if (char.IsControl(e.KeyChar))//no permitira ingresar espacios
            {
                e.Handled = false;
            }
            else if ((e.KeyChar == '+') && (!txtprecioPro.Text.Contains("+")))//+569
            {
                e.Handled = false;
            }
            else
            {
                e.Handled = true;
                MessageBox.Show("Solo se Admiten numeros", "Validación numeros", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                txtTelefono.SelectAll();
                txtTelefono.Focus();
            }
        }

        public String formatear(String rut)
        {
            int cont = 0;
            String format;
            if (rut.Length == 0)
            {
                return "";
            }
            else
            {
                rut = rut.Replace(".", "");
                rut = rut.Replace("-", "");
                format = "-" + rut.Substring(rut.Length - 1);
                for (int i = rut.Length - 2; i >= 0; i--)
                {

                    format = rut.Substring(i, 1) + format;

                    cont++;
                    if (cont == 3 && i != 0)
                    {
                        format = "." + format;
                        cont = 0;
                    }
                }
                return format;
            }
        }

        private void txtRutCliente_Leave(object sender, EventArgs e)
        {
            
            this.txtRutCliente.Text = formatear(this.txtRutCliente.Text);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lblHora.Text ="Fecha Actual: "+ DateTime.Now.ToString("MM/dd/yyyy HH:mm:ss");
        }
    } 
}



