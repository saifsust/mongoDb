<h1>
	Upload Post <small>admin</small>
</h1>

<!-- Upload post -->
<form method="post" action="uploadPost">

	<input type="hidden" name="authorId" value="123523523" />
	<div class="form-group">
		<label>Title</label> <input type="text" name="title"
			class="form-control" />
	</div>
	<div class="form-group">
		<label>Description</label>
		<p>For bold use || and For link use <></p>
		<textarea rows="14" cols="" name="description" class="form-control"></textarea>
	</div>
	<div class="form-group">
		<label>Upload File</label> <input type="file" name="fileLink"
			class="btn btn-primary" />
	</div>
	<input type="submit" name="sumit" class="btn btn-primary" />
</form>

