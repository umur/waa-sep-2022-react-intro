import React from "react";

import PostAuthor from "./PostAuthor";
import TimeAgo from "./TimeAgo";

const PostsExcerpt = ({ post }) => {
  return (
    <article>
      <h3>{post.title}</h3>
      <p>{post.body.substring(0, 100)}</p>
      <p>
        <PostAuthor userId={post.userId} />

        <TimeAgo timeStamp={post.date} />
      </p>
    </article>
  );
};

export default PostsExcerpt;
