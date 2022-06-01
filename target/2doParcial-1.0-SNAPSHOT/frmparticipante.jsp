
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Punto de Venta</title>
    </head>
    <body>
        <div class="container" style="margin-top: 80px">
            <h1>Formulario de Participantes</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include>
            <br>
            <form action="ParticipanteController" method="post">
                <input type="hidden" name="id" value="${participante.id}">
                <div class="mb-3">
                    <label for="" class="form-label">Apellido: </label>
                    <input type="text" class="form-control" name="apellido" value="${participante.apellidos}" placeholder="Escriba su nombre completo">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Nombre: </label>
                    <input type="text" class="form-control" name="nombre" value="${participante.nombres}" placeholder="Escriba su nombre completo">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Seminario: </label>
                    <input type="text" class="form-control" name="id_seminario" value="${participante.seminario_id}" placeholder="Escriba su correo electrónico">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Confirmado: </label>
                    <input type="text" class="form-control" name="confirmado" value="${participante.confirmado}" placeholder="Escriba su numero de celular">
                </div>

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
