
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

        <title>Participantes</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="opcion" value="participantes"/>
        </jsp:include>
        <main class="container" style="margin-top: 80px">
  <br><div style="border:PowderBlue 5px solid;border-radius: 40px;margin: auto 200px" >
 <center><h3>SEGUNDO PARCIAL TEM-742</h3><h4>Nombre : Alex Churata Mamani Carnet: 9950103 LP </h4></center></div>
            <h1>Participantes</h1>
            <a href="ParticipanteController?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <hr>
            <table class="table table-striped">

                <tr>
                    <th>Id</th>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Seminario</th>
                    <th>Confirmado</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${participan}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.apellidos}</td>
                        <td>${item.nombres}</td>
                        <td>${item.seminario}</td>
                        <%
                            int opcion = 1;
                        %> 
                        <td><div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckChecked" <c:if test="${item.confirmado == 1}" var="res" scope="request">checked</c:if> >
                            </div>
                        </td>
                        <td><a href="ParticipanteController?action=edit&id=${item.id}"><i class="fa-solid fa-file-pen"></i></a></td>
                        <td><a href="ParticipanteController?action=delete&id=${item.id}"
                               onclick="return(confirm('Esta seguro de eliminar el registro? '))"
                               ><i class="fa-solid fa-trash-can"></i></a></td>
                    </tr>
                </c:forEach>

            </table>
            <hr>
            <%--    <a href="Logout" class="btn btn-danger">Cerrar Sesion</a> --%>
        </main>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


    </body>
</html>
