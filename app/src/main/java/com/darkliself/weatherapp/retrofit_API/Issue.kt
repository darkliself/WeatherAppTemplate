package com.darkliself.weatherapp.retrofit_API

data class Issue(
    val author: Author,
    val closed_on: Any,
    val created_on: String,
    val custom_fields: List<CustomField>,
    val description: String,
    val done_ratio: Int,
    val due_date: Any,
    val estimated_hours: Any,
    val id: Int,
    val is_private: Boolean,
    val parent: Parent,
    val priority: Priority,
    val project: Project,
    val start_date: Any,
    val status: Status,
    val subject: String,
    val total_estimated_hours: Any,
    val tracker: Tracker,
    val updated_on: String
)