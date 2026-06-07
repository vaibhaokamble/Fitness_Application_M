## 2026-06-07 - Missing Database Indexes in Spring Data JPA Repositories
**Learning:** Even simple Spring Data JPA repositories can suffer from N+1 or slow queries if fields frequently used in `findBy...` methods lack database indexes. Adding `@Index` within `@Table` solves this issue efficiently at the entity level.
**Action:** Always check the repository interfaces (e.g., `RecommendationRepository.java`) to find heavily queried fields (like `userId` or `activityId`) and ensure there is an index defined on the corresponding entity model.
