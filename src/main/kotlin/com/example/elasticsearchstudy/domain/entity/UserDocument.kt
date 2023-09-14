package com.example.elasticsearchstudy.domain.entity

import org.springframework.data.elasticsearch.annotations.*
import java.time.LocalDateTime
import javax.persistence.Id

@Document(indexName = "user")
@Mapping(mappingPath = "elastic/user-mapping.json")
@Setting(settingPath = "elastic/user-setting.json")
class UserDocument(
    @Id
    val id: Int = 0,

    val name: String,

    val age: Int,

    val description: String,

    @Field(type = FieldType.Date, format = [DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis])
    val createdAt: LocalDateTime,
)