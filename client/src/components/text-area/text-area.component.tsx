import React, { useState } from 'react';
import { motion } from 'framer-motion';
import remarkGfm from 'remark-gfm';
import ReactMarkdown from 'react-markdown';
import './text-area.styled';
import { StyledDiv } from './text-area.styled';

export const TextArea: React.FC = () => {
  const [value, setValue] = useState('');
  const [preview, setPreview] = useState(false);

  const handleInputChange = (event: React.ChangeEvent<HTMLTextAreaElement>) =>
    setValue(event.target.value);
  const handleClick = () => setPreview(!preview);

  return (
    <StyledDiv>
      {!preview && (
        <div className="w-full bg-brand-900 flex">
          <textarea
            value={value}
            onChange={handleInputChange}
            className={[
              'outline-none',
              'border-none',
              'ring-0',
              'bg-brand-700',
              'resize-none',
              'w-full',
              'h-[300px]',
              'p-6',
              'text-brand-50',
            ].join(' ')}
          />

          <button
            onClick={handleClick}
            className={[
              'bg-brand-900',
              'hover:bg-brand-500',
              'text-zinc-100',
              'p-2',
              'rounded-lg',
              'text-sm',
              'transition-all',
              'ease-in-out',
              'duration-200',
            ].join(' ')}
            placeholder="Describe your problem"
          >
            Preview
          </button>
        </div>
      )}

      {!!preview && (
        <motion.div className="">
          <ReactMarkdown
            children={value}
            remarkPlugins={[remarkGfm]}
            className={[
              'markdown',
              'bg-brand-900',
              'p-6',
              'resize-none',
              'w-full',
              'overflow-scroll',
              'text-brand-50',
            ].join(' ')}
          />

          <button
            className={[
              'bg-brand-800',
              'hover:bg-brand-500',
              'text-zinc-100',
              'p-2',
              'rounded-lg',
              'text-sm',
              'transition-all',
              'ease-in-out',
              'duration-200',
            ].join(' ')}
            onClick={handleClick}
          >
            Show Original
          </button>
        </motion.div>
      )}
    </StyledDiv>
  );
};
