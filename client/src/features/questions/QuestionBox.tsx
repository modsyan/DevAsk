import { Link } from 'react-router-dom';
import { MdOutlineInsertComment } from 'react-icons/md';
import { VoteCounter } from './vote/VoteCounter';
export interface User {
  id: string;
  firstname: string;
  lastname: string;
  username: string;
  email: string;
  profilePicture: string;
}
export interface Question {
  id: string;
  user: User;
  title: string;
  content: string;
  createdAt: Date;
  updatedAt?: Date;
  tags: string[];
  votes: number;
  noAnswers: number;
  solutions?: {
    id: number;
    user: User;
    title: string;
    content: string;
    comments: [];
    votes: [];
    createdAt: Date;
    updatedAt: Date;
  }[];
}

// enum BOX_STYLES {
//   FEED = `h-52`,
//   DETAILS = ``,
// }

// enum HEADING_STYLES {
//   FEED = `text-xl font-medium`,
//   DETAILS = ``,
// }

// enum CONTENT_STYLES {
//   FEED = `h-52 `,
//   DETAILS = ``,
// }

export const QuestionBox: React.FC<{
  question: Question;
  state: 'feed' | 'details';
  className?: string;
}> = ({ question, state, className }) => {
  const { user, title, content, createdAt } = question;
  const { id } = question;
  const tags = ['one', 'two', 'three', 'four'];
  // const { votes } = question;
  console.log(question.solutions?.length);

  return (
    <>
      {/* Problem Box */}

      {state === 'details' && (
        <div
          className={`text-zinc-50  bg-slate-900 min-h-48 flex  gap-6 ${className} `}
        >
          <div className="relative ">
            <VoteCounter />
          </div>
          <div className="flex flex-col gap-3">
            {/* Title - Date - Author */}
            <div className="flex justify-between items-center ">
              <header className="flex flex-col gap-4">
                <h1
                  className={`text-2xl font-medium hover:text-sky-400 hover:underline transition-all ease-in-out duration-200 hover:transition-all hover:ease-in-out hover:duration-200 hover:text-3xl`}
                >
                  {title}
                </h1>
                <div className="flex gap-6 text-xs font-medium">
                  <span>
                    Asked by{' '}
                    <span className="text-zinc-400">{user.username}</span>
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
              <div className="text-zinc-400 flex py-50 line-clamp-2  overflow-hidden w-[90%] my-12 font-medium font-sans">
                {content +
                  'lorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem lorelorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremm'}
              </div>
              {/* Tags - Interactions */}
              <div className="flex items-center gap-5 justify-between">
                {/* Tags */}
                <div className="flex gap-3">
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
        </div>
      )}
      {state === 'feed' && (
        <div
          className={`text-zinc-50 p-6  bg-brand-900 h-48 flex flex-col gap-3 ${className}`}
        >
          {/* Title - Date - Author */}
          <header className="flex flex-col gap-4">
            <Link to={`/questions/${id}`}>
              <h1
                className={`text-lg font-medium hover:text-sky-400 hover:underline transition-all ease-in-out duration-200 hover:transition-all hover:ease-in-out hover:duration-200 hover:text-xl`}
              >
                {title}
              </h1>
            </Link>
            <div className="flex gap-6 text-xs font-medium">
              <span>
                Asked by <span className="text-zinc-400">{user.username}</span>
              </span>
              <p>{createdAt.toString()}</p>
            </div>
          </header>
          {/* Desc - Interaction - Tags */}
          <div className="flex flex-col justify-evenly">
            {/* Desc */}
            <div className="text-zinc-300 flex py-50 line-clamp-2 max-h-12 overflow-hidden">
              {content +
                'lorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem lorelorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremlorem loremm'}
            </div>
            {/* Tags - Interactions */}
            <div className="flex items-center gap-5">
              {/* Tags */}

              <div className="flex gap-1">
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
            </div>
          </div>
        </div>
      )}
    </>
  );
};
