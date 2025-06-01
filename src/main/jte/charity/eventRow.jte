@param com.npo.domain.Event event

<div class="card mb-3" style="width: 100%;">
    <div class="card-body">
        <h5 class="card-title">${event.getName()}</h5>
        <h6 class="card-subtitle mb-2 text-body-secondary">${event.getStartDate().format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE)}</h6>
        <p class="card-text">${event.getDescription()}</p>
    </div>
</div>