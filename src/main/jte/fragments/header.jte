@param String currentUsername = null

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">U.K. Charities</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/charities">Charities</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/charities/registration">Charity Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/events/new">New Event</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/members/registration">Reg</a>
                </li>
                @if(currentUsername == null)
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                @else
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">logout</a>
                    </li>
                @endif
            </ul>
            @if(currentUsername != null)
                <div class="d-flex badge text-bg-secondary">
                    ${currentUsername}
                </div>
            @endif
        </div>
    </div>
</nav>