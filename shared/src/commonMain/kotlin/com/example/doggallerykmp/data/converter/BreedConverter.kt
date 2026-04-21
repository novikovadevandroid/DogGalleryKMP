package com.example.doggallerykmp.data.converter

import com.example.doggallerykmp.models.data.BreedsDto
import com.example.doggallerykmp.models.domain.Breed

fun BreedsDto.toBreeds() = this.name.keys.map {
    Breed(name = it)
}