<h1>
	Upload Post <small>admin</small>
</h1>

<!-- Upload post -->
<form method="post" modelAttribute="post"  action="uploadPost" enctype="multipart/form-data"  >

	<input type="hidden" name="authorId" value="123523523" required="required" />
	<div class="form-group">
		<label>Title</label> <input type="text" name="title"
			class="form-control"  required="required" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<p>For bold use || and For link use <></p>
		<textarea rows="14" cols="" name="description" class="form-control" required="required" ></textarea>
	</div>
	<div class="form-group">
		<label>Upload File</label> <input type="file" name="fileLinks"
			class="btn btn-primary" multiple="multiple"  />
	</div>
	<input type="submit" name="sumit" class="btn btn-primary" />
</form>

