import java.sql.Timestamp;


public class Task {
   private long id;
   private long category_id;
   private String title;
   private String description;
   private Timestamp createdDate;
   private Timestamp dueDate;
   private boolean isDone;

   public Task(long id, long category_id, String title, String description, Timestamp createdDate, Timestamp dueDate, boolean isDone) {
      this.id = id;
      this.category_id = category_id;
      this.title = title;
      this.description = description;
      this.createdDate = createdDate;
      this.dueDate = dueDate;
      this.isDone = isDone;
   }

   public Task(long category_id, String title, String description, Timestamp createdDate, Timestamp dueDate, boolean isDone) {
      this.category_id = category_id;
      this.title = title;
      this.description = description;
      this.createdDate = createdDate;
      this.dueDate = dueDate;
      this.isDone = isDone;
   }

   public long getId() {
      return id;
   }

   public long getCategory_id() {
      return category_id;
   }

   public String getTitle() {
      return title;
   }

   public String getDescription() {
      return description;
   }

   public Timestamp getCreatedDate() {
      return createdDate;
   }

   public Timestamp getDueDate() {
      return dueDate;
   }

   public boolean isDone() {
      return isDone;
   }

   @Override
   public String toString() { return "Task: " + title + " created at " + createdDate;
   }
}
