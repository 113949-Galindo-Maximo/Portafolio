using APICRUDDBfirst.Data;
using APICRUDDBfirst.ModelosDTO;
using APICRUDDBfirst.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace APICRUDDBfirst.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BarcoSimpleController : ControllerBase
    {
        public readonly ContextDB _context;

        public BarcoSimpleController(ContextDB context)
        {
            _context = context;
        }

        [HttpGet]
        public async Task<List<BarcoDTO>> GetBarcos()
        {
            var resultado = _context.Barcos
                .Select(b => new BarcoDTO
                {
                    Nombre = b.Nombre,
                    Cuota = b.Cuota,               
                    IdSocio = b.IdSocio,
                    Socio = new SocioDTO
                    {                     
                        Nombre = b.IdSocioNavigation.Nombre,
                        Apellido = b.IdSocioNavigation.Apellido
                    }
                }).
                ToListAsync();

       

            return await resultado;
        }

        [HttpPost]
        public async Task<Barco> PostBarco(BarcoDTO request)
        {
            try
            {
                var newBarco = new Barco
                {
                    Nombre = request.Nombre,
                    Cuota = request.Cuota,
                    IdSocio = request.IdSocio
                };

                _context.Barcos.Add(newBarco);
                _context.SaveChanges();

                return newBarco;
            }
            catch (Exception ex)
            {
                throw ex;
            }
          
        }

    }
}
