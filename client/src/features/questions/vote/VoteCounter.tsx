import { useState } from 'react';
import {
  BsFileArrowDown,
  BsFileArrowDownFill,
  BsFileArrowUp,
  BsFileArrowUpFill,
} from 'react-icons/bs';
type State = null | boolean;

export const VoteCounter = () => {
  // true stands for up , false stands for down
  const [vote, setVote] = useState<State>(null);

  const handleToggleUp = () => {
    if (vote === null || !vote) {
      setVote(true);
      return;
    }
    setVote(null);
  };
  const handleToggleDown = () => {
    if (vote === null || vote) {
      setVote(false);
      return;
    }
    setVote(null);
  };

  return (
    <>
      <div>
        <div className="flex flex-col gap-4 items-center">
          {vote ? (
            <BsFileArrowUpFill
              className="text-4xl text-zinc-200"
              onClick={handleToggleUp}
            />
          ) : (
            <BsFileArrowUp
              className="text-4xl text-zinc-200"
              onClick={handleToggleUp}
            />
          )}
          <span className="text-xl font-bold text-sky-400">{20}</span>
          {vote === false ? (
            <BsFileArrowDownFill
              className="text-4xl text-zinc-200"
              onClick={handleToggleDown}
            />
          ) : (
            <BsFileArrowDown
              className="text-4xl text-zinc-200"
              onClick={handleToggleDown}
            />
          )}
        </div>
      </div>
    </>
  );
};
