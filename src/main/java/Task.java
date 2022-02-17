import java.util.Date;

public class Task {
   private long id;
   private long category_id;
   private String title;
   private String description;
   private Date createdDate;
   private Date dueDate;
   private boolean isDone;

   public Task(long id, long category_id, String title, String description, Date createdDate, Date dueDate, boolean isDone) {
      this.id = id;
      this.category_id = category_id;
      this.title = title;
      this.description = description;
      this.createdDate = createdDate;
      this.dueDate = dueDate;
      this.isDone = isDone;
   }

   public Task(long category_id, String title, String description, Date createdDate, Date dueDate, boolean isDone) {
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

   public Date getCreatedDate() {
      return createdDate;
   }

   public Date getDueDate() {
      return dueDate;
   }

   public boolean isDone() {
      return isDone;
   }

   @Override
   public String toString() { return "Task: " + title;
   }
}
