
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

        <title>Listado Seminarios</title>
    </head>
    <body>
        <div class="container" style="margin-top: 80px">
            <h1>Seminarios</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="seminarios"/>
            </jsp:include>
       <br><div style="border:PowderBlue 5px solid;border-radius: 40px;margin: auto 200px" >
 <center><h3>SEGUNDO PARCIAL TEM-742</h3><h4>Nombre : Alex Churata Mamani Carnet: 9950103 LP </h4></center></div>
            <br>
            <a href="SeminarioController?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br><br>
            <hr>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Cupo</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${seminarios}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.fecha}</td>
                        <td>${item.cupos}</td>
                        <td><a href="SeminarioController?action=edit&id=${item.id}"><i class="fa-solid fa-file-pen"></i></a></td>
                        <td><a href="SeminarioController?action=delete&id=${item.id}"
                               onclick="return(confirm('Esta seguro de eliminar el registro? '))"
                               ><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
