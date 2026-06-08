## 2026-06-08 - Added Index on RecommendationModel
**Learning:** Frequent query operations on specific columns can lead to performance bottlenecks. Adding indexes directly at the JPA entity level improves read times.
**Action:** Always verify frequently queried fields in `@Entity` models and add appropriate indexes for read-heavy microservices.
