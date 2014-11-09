INSERT INTO tipo_usuario(id_tipo_usuario, ds_tipo_usuario, cd_pagina_acesso) VALUES (1, 'Administrador', 'home,tipoUsuarios,usuarios,empresa');
INSERT INTO tipo_usuario(id_tipo_usuario, ds_tipo_usuario, cd_pagina_acesso) VALUES (2, 'Empresa', 'home,');
INSERT INTO tipo_usuario(id_tipo_usuario, ds_tipo_usuario, cd_pagina_acesso) VALUES (3, 'Estagio', 'home,');

INSERT INTO usuario(id_usuario, id_tipo_usuario, cd_email, cd_senha)
    VALUES (1, 1, 'admin@ifce.edu.br','e8d95a51f3af4a3b134bf6bb680a213a');
INSERT INTO usuario(id_usuario, id_tipo_usuario, cd_email, cd_senha)
    VALUES (2, 2, 'empresa@ifce.edu.br','e8d95a51f3af4a3b134bf6bb680a213a');  
INSERT INTO usuario(id_usuario, id_tipo_usuario, cd_email, cd_senha)
    VALUES (3, 3, 'estagio@ifce.edu.br','e8d95a51f3af4a3b134bf6bb680a213a');
