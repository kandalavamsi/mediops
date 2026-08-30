# MediOps Database Schema

## Overview

MediOps uses PostgreSQL as its relational database.

The database is designed around patient management, healthcare
resources, appointments, emergencies, admissions, clinical records,
vitals, prescriptions, and audit tracking.

## Tables

| Table | Purpose |
|---|---|
| users | Application users and authentication-related information |
| departments | Hospital departments |
| patients | Patient demographic and identification information |
| doctors | Doctor information and department assignment |
| wards | Hospital wards |
| beds | Beds available within wards |
| appointments | Scheduled patient-doctor appointments |
| emergencies | Emergency cases and triage information |
| admissions | Patient hospital admissions |
| medical_records | Clinical records and diagnoses |
| patient_vitals | Historical patient vital measurements |
| prescriptions | Medication prescriptions |
| audit_logs | System activity and audit history |
## Relationships

- departments → doctors
- departments → wards
- wards → beds
- patients → appointments
- doctors → appointments
- departments → appointments
- patients → emergencies
- doctors → emergencies
- departments → emergencies
- patients → admissions
- doctors → admissions
- beds → admissions
- emergencies → admissions
- patients → medical_records
- doctors → medical_records
- appointments → medical_records
- patients → patient_vitals
- patients → prescriptions
- doctors → prescriptions
- medical_records → prescriptions
- users → audit_logs
## Design Decisions

### Patient contact information

Patient email is optional because not every patient will have
an email address.

### Patient vitals

Vitals are stored separately from the patients table because
vitals change over time.

A patient can therefore have multiple vital records.

Examples:

- Heart rate
- Blood pressure
- Temperature
- Oxygen saturation
- Blood glucose
- Height
- Weight

### Audit logging

Important application activity is stored in audit_logs to provide
traceability of system actions.

### Indexing

Indexes are added based on expected application query patterns,
particularly for patient, doctor, department, appointment,
admission, emergency, medical-record, prescription, vital,
bed, ward, and audit-log lookups.