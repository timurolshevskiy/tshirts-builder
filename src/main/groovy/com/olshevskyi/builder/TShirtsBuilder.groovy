package com.olshevskyi.builder

import com.olshevskyi.domain.TShirt

interface TShirtsBuilder {

    List<TShirt> buildTShirts(List<String> words)

}
