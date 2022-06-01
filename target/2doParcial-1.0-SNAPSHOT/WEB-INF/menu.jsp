<%

    String opcion = request.getParameter("opcion");

%> 
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark mb-4" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Sistema de Seminarios</a>
    <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link <%= (opcion.equals("seminarios")?"active":"")%>" href="SeminarioController" aria-current="page" >Seminarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%= (opcion.equals("participantes")?"active":"")%>" href="ParticipanteController">Participantes</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
