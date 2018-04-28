<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8" />
        <title>Desenvolvimento de Sistemas Web III</title>
        <link rel="stylesheet" type="text/css" href="index.css" />
        <script type="text/javascript" src="index.js"></script>
    </head>
    <body>
        <h1>Cadastro de funcionários</h1>

        <table id="lista">
            <thead>
                <tr>
                    <th><img id="inserir" src="imgs/inserir.png" alt="Inserir funcionário" /></th>
                    <th>Nome</th>
                    <th>Data de Nascimento</th>
                    <th>Salário</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
        <form action="Exemplo6b" method="post" id="form">
            <input type="hidden" name="codigo" value="" />
            <fieldset id="formulario"><legend>Dados</legend>
                <table>
                    <tr>
                        <th>Nome:</th>
                        <td><input type="text" name="nome" /></td>
                    </tr>
                    <tr>
                        <th>Data de Nascimento:</th>
                        <td><input type="text" name="dataNascimento" /></td>
                    </tr>
                    <tr>
                        <th>Salário:</th>
                        <td><input type="text" name="salario" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Inserir" name="submeter" /></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>