import { User } from '../QuestionBox';

interface Solution {
  id: string;
  user: User;
  title: string;
  content: string;
  comments: [];
  votes: [];
  createdAt: Date;
  updatedAt: Date;
}

export const SolutionBox: React.FC<{
  solution: Solution;
  className?: string;
}> = ({ solution, className }) => {
  const { user, title, content, createdAt, votes, comments } = solution;

  // const { votes } = question;

  return (
    <>
      {/* Problem Box */}

      <div
        className={`text-zinc-50 p-6  bg-brand-900 min=h-48 flex flex-col gap-3 ${className}`}
      >
        {/* Title - Date - Author */}
        <div className="flex justify-between items-center">
          <header className="flex flex-col gap-4">
            <h1
              className={`text-lg font-medium hover:text-sky-400 hover:underline transition-all ease-in-out duration-200 hover:transition-all hover:ease-in-out hover:duration-200 hover:text-xl`}
            >
              {title}
            </h1>
            <div className="flex gap-6 text-xs font-medium">
              <span>
                Asked by <span className="text-zinc-400">{user.username}</span>
              </span>
              <p>{createdAt.toString()}</p>
            </div>
          </header>
          <div className="flex flex-col text-sky-400">
            <span>{0} Votes</span>
            <span>{question.solutions?.length} Solution</span>
          </div>
        </div>
        {/* Desc - Interaction - Tags */}
        <div className="flex flex-col justify-evenly gap-3">
          {/* Desc */}
          <div className="text-zinc-400 flex py-50 line-clamp-2  overflow-hidden">
            {content +
              'lorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem lorelorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremm'}
          </div>
          {/* Tags - Interactions */}
          <div className="flex items-center gap-5 justify-between">
            {/* Tags */}
            <div className="flex gap-2">
              {tags &&
                tags.map((tag, index) => (
                  <span
                    key={index}
                    className="px-2 py-1 bg-zinc-700 rounded-lg"
                  >
                    {tag}
                  </span>
                ))}
            </div>
            <div className="flex gap-2 items-center hover:text-sky-400 hover:cursor-pointer hover:underline transition-all ease-out duration-200">
              <MdOutlineInsertComment />
              <span className="text-zinc-200 uppercase font-semibold">
                Comment
              </span>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
