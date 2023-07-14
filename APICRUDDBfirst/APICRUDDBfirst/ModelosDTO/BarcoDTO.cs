using APICRUDDBfirst.Models;

namespace APICRUDDBfirst.ModelosDTO
{
    public class BarcoDTO
    {     

        public string? Nombre { get; set; }

        public long? Cuota { get; set; }       

        public long IdSocio { get; set; }

        public virtual SocioDTO Socio { get; set; } = null;
    }
}
