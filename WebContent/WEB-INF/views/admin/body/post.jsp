<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>
	Upload Post <small>admin</small>
</h1>
<!-- Upload post -->
<form method="post" modelAttribute="post"  action="uploadPost" enctype="multipart/form-data"  >

	<input type="hidden" name="authorId" value="5a67193660704e7636809f2b" required="required" />
	<div class="form-group">
		<label>Title</label> <input type="text" name="title"
			class="form-control"  required="required" value="${post.title}"  />
	</div>
	
	<div class="form-group">
		<label>Description</label>
		<p>For bold use || and For link use <></p>
		<textarea rows="14" cols="" name="description" class="form-control" required="required">${post.description} </textarea>
	</div>
	<div class="form-group">
		<label>Upload File</label> <input type="file" name="fileLinks"
			class="btn btn-primary" multiple="multiple"  />
	</div>
	<input type="submit" name="sumit" class="btn btn-primary" />
</form>

