## Splitwise

### Requirements

**Functional**:
- Users can create groups with other members and expenses
- Payment graph can be generated from the group
- User can query how much he/she owes from groups



### Entities

- Group
  - Group metadata
- User
  - Group members
- Expense

### Service class
- PaymentGraph

### Enums

- UserRole [ Admin, Member]

### Models

```
Group:
- group_id: int
- group_metadata: GroupMetadata
- author_id: int

Group Metadata:
- name: string,
- description

Group members:
- user_id: int, 
- group_id: int
- expense: Expense
- role: UserRole

Expense
- user_id: int,
- amount: int
- group_id: int

User
- user_id: int,
- name: string

```

### Exceptions


