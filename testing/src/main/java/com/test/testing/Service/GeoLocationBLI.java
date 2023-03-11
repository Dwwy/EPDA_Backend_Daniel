package com.test.testing.Service;

import com.test.testing.Model.Input.GeoLocationInput;
import com.test.testing.Model.UpdateInput.GeoLocationUpdate;
import com.test.testing.response.Response;

public interface GeoLocationBLI {
    Response createGeolocation (GeoLocationInput input);
    Response update(GeoLocationUpdate input);
}
