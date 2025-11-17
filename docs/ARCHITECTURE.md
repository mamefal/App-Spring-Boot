# Architecture (v0.1)

## Modules
- **domain/** : entités JPA + enums
- **repo/** : interfaces Spring Data
- **service/** : logique métier
- **api/** : contrôleurs REST + DTO
- **resources/** : config + seeds

## Enums
- `Priority`: LOW, MEDIUM, HIGH, CRITICAL
- `Status`: NEW, IN_PROGRESS, RESOLVED, CLOSED

## Entités 
- **User** → id, email, fullName
- **Category** → id, name
- **Ticket** → title, description, priority, status, requester, assignee, category, createdAt, updatedAt
- **Comment** → ticket, author, body, createdAt  
