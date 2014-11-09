package br.edu.ifce.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.ifce.exception.DAOException;

public class UsuarioDAOTest {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	@Test
	public void testList() {
		try {
			assertTrue(usuarioDAO.list().size() > 0);
		} catch (DAOException e) {

		}
	}

	@Test
	public void test() {
		// Usuario usuario = new Usuario();
		// usuario.setCdEmail("fdgdg");

		//
		// UsuarioDAO dao =new UsuarioDAO();
		//
		//
		// try {
		// dao.add(usuario);
		// } catch (DAOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// try {
		// for (Usuario us : dao.list()) {
		// System.out.println(us.getCdEmail() +" - " + us.getCdEmail());
		// }
		// } catch (DAOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
