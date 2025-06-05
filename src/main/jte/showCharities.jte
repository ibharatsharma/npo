@import com.npo.domain.Charity
@import com.npo.domain.WebUser

@param WebUser user
@param java.util.List<Charity> charities


@template.layouts.base(content = @`

    <div class="container-fluid">
        <div class="row mb-4 mt-4">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                <h3>Found ${charities.size()} Charities</h3>
            </div>
            <div class="col-sm-3"></div>
        </div>

    @for(Charity charity : charities)
        <div class="row mb-4 mt-4">
            <div class="col-sm-3"></div>
            <div class="col-sm-6 mb-3 mb-sm-0">
                @template.charityRow(charity = charity)
            </div>
            <div class="col-sm-3"></div>
        </div>
    @endfor
    </div>
`, title = "Charities", user = user)
