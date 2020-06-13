package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

@Path("projetos")
public class ProjetoResource {

    @Path("{id}")
    @GET
    public Projeto busca(@PathParam("id") long id) {
	Projeto projeto = new ProjetoDAO().busca(id);
	return projeto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(String conteudo) {
	Projeto projeto = (Projeto) new XStream().fromXML(conteudo);
	new ProjetoDAO().adiciona(projeto);
	URI uri = URI.create("/projetos/" + projeto.getId());
	return Response.created(uri).build();
    }

    @Path("{id}")
    @DELETE
    public Response removeProjeto(@PathParam("id") long id) {
	new ProjetoDAO().remove(id);
	return Response.ok().build();
    }
}