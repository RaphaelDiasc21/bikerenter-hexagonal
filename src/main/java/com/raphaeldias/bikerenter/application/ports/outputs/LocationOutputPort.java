package com.raphaeldias.bikerenter.application.ports.outputs;

import com.raphaeldias.bikerenter.application.domain.Location;

public interface LocationOutputPort {
    Location save(Location location);
}
