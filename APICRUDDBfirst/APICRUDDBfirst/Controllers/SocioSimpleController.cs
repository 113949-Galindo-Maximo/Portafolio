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
    public class SocioSimpleController : ControllerBase
    {
        private readonly ContextDB _context;

        public SocioSimpleController(ContextDB context)
        {
            _context = context;
        }

        [HttpGet]

        public async Task<List<Socio>> GetSocios()
        {
            var resultado = _context.Socios.ToList();
            return resultado;
        }

        [HttpGet("{id}")]
        public async Task<Socio> GetSocioById(int id)
        {
            var resultado = await _context.Socios.FirstOrDefaultAsync(x => x.IdSocio == id);
            return resultado;
        }

        [HttpPost]
        public async Task<Socio> PostSocio(SocioDTO request)
        {
            try
            {
                var newSocio = new Socio
                {
                    Nombre = request.Nombre,
                    Apellido = request.Apellido
                };

                await _context.AddAsync(newSocio);
                await _context.SaveChangesAsync();
                return newSocio;
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        [HttpPut("{id}")]
        public async Task<Socio> PutSocio(long id, SocioDTO request)
        {
            try
            {
                var updateSocio = await _context.Socios.FindAsync(id);
               
                if(updateSocio != null)
                {
                    updateSocio.Nombre = request.Nombre;
                    updateSocio.Apellido = request.Apellido;
                }
                _context.SaveChanges();
                return updateSocio;                                 


            }
            catch(Exception ex)
            {
                throw ex;
            }
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSocio(long id)
        {
            try
            {
                var deleteSocio = await _context.Socios.FindAsync(id);
                _context.Socios.Remove(deleteSocio);
                await _context.SaveChangesAsync();

                return NoContent();
            }
            catch(Exception ex)
            {
                throw ex;
            }
        }

    }
}
