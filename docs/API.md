# API v1

## Santé
`GET /api/health` → "OK"

## Tickets
### Lister
`GET /api/tickets?status=NEW&priority=HIGH`

### Créer
```json
{
  "title": "PC en panne",
  "description": "Ne démarre plus",
  "priority": "HIGH",
  "categoryId": 2,
  "requesterEmail": "user@local"
}
